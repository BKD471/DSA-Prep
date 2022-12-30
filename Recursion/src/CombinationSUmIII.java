import java.util.ArrayList;
import java.util.List;

class Solution24 {
    public static void comboSum(int[] nums,List<List<Integer>> res,List<Integer> temp,int target,int size,int index){

        if(target==0 && size==0){
            res.add(new ArrayList<>(temp));
            return;
        }

        //target has gone below 0 i.e we have excedded the target and solution not found
        if(target<0 || size<0) return;

        //We have finsihed searching through entire nos from [1-9] still target is non zero so quit
        if(index==nums.length) return;

        temp.add(nums[index]);
        comboSum(nums,res,temp,target-nums[index],size-1,index+1);
        temp.remove(temp.size()-1);
        comboSum(nums,res,temp,target,size,index+1);
    }
    public static List<List<Integer>> combinationSum3(int size, int target) {
        List<List<Integer>> res=new ArrayList();
        List<Integer> temp=new ArrayList();
        int[] nums=new int[9];
        for(int i=1;i<=9;i++) nums[i-1]=i;
        comboSum(nums,res,temp,target,size,0);
        return res;
    }
}


public class CombinationSUmIII {
    public static void main(String[] args) {
        List<List<Integer>> res=Solution24.combinationSum3(3,7);
        res.forEach(t-> System.out.println(res));
    }
}
