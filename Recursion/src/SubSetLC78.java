import java.util.ArrayList;
import java.util.List;

import static helper.CodeHelper.displayListOfList;

class Solution5 {
    public static void subSets(List<List<Integer>> res, List<Integer> temp, int index, int[] nums){
        if(index==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        subSets(res,temp,index+1,nums);
        temp.remove(temp.size()-1);
        subSets(res,temp,index+1,nums);

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        List<Integer> temp=new ArrayList();
        subSets(res,temp,0,nums);
        return res;
    }
}


public class SubSetLC78 {
    public static void main(String[] args) {
        int[] arr={2,3,6,7};
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> ans=Solution5.subsets(arr);
        displayListOfList(ans);
    }
}
