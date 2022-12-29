import java.util.*;

class Solution22 {

    public static void swap(int[] nums,int l,int h){
        int t=nums[l];
        nums[l]=nums[h];
        nums[h]=t;
    }
    public static void solve(List<List<Integer>> res,int[] nums,int index){
        if(index==nums.length-1){

            List<Integer> temp=new ArrayList<>();
            for(int t:nums) temp.add(t);

            res.add(temp);
            return;
        }
        Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
        for(int i=index;i<nums.length;i++){
            if(hash.get(nums[i])==null){
                hash.put(nums[i],i);
                swap(nums,i,index);
                solve(res,nums,index+1);
                swap(nums,i,index);
            }
        }

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        solve(res,nums,0);

        return res;
    }
}



public class PermutationII {
    public static void main(String[] args) {
        int[] nums={1,2,2,3};
        List<List<Integer>> r=Solution22.permuteUnique(nums);
        r.forEach(t-> System.out.println(t));

    }
}
