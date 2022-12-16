import java.util.ArrayList;
import java.util.List;

import static helper.CodeHelper.displayListOfList;

class Solution {

    public static void comboSum(int[] candidates,int target,List<List<Integer>> res,List<Integer> temp,int index){

        if(index==candidates.length){
            if(target==0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if(candidates[index]<=target){
            temp.add(candidates[index]);
            comboSum(candidates,target-candidates[index],res,temp,index);
            temp.remove(temp.size()-1);
        }
        comboSum(candidates,target,res,temp,index+1);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList();
        List<Integer> temp=new ArrayList();
        comboSum(candidates,target,res,temp,0);
        return res;
    }
}



public class ComboSumLC39 {
    public static void main(String[] args) {
        int[] arr={2,3,6,7};
        int target=7;
        List<List<Integer>> result=Solution.combinationSum(arr,target);
        displayListOfList(result);
    }
}
