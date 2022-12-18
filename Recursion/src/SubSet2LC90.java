import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static helper.CodeHelper.displayListOfList;

class Solution4 {
    public static void subSets(List<List<Integer>> res, List<Integer> temp, int index, int[] nums){
        res.add(new ArrayList<>(temp));
        //return;
        //}
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            subSets(res,temp,i+1,nums);
            temp.remove(temp.size()-1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList();
        List<Integer> temp=new ArrayList();
        subSets(res,temp,0,nums);
        return res;
    }
}
public class SubSet2LC90 {
    public static void main(String[] args) {
         int[] arr={1,2,2,2,3,3};
         List<List<Integer>> res=Solution4.subsetsWithDup(arr);
         displayListOfList(res);
    }
}
