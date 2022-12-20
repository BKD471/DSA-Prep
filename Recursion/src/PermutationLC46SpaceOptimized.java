import java.util.ArrayList;
import java.util.List;

import static helper.CodeHelper.displayListOfList;
import static helper.CodeHelper.swapHelper;

class Solution7 {
    public static void permutation(int[] nums, List<List<Integer>> res, int index)
    {
        if(index==nums.length){
            List<Integer> temp=new ArrayList();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swapHelper(nums,i,index);
            permutation(nums,res,index+1);
            swapHelper(nums,i,index);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        permutation(nums,res,0);
        return res;
    }
}

public class PermutationLC46SpaceOptimized {

    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> res=Solution7.permute(arr);
        displayListOfList(res);
    }
}
