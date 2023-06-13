import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<List<Integer>> ans= Solution5DP.subsets(arr);
        //displayListOfList(ans);

        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(2,1);
        mp.remove(2);

        System.out.println(mp);
        //System.out.println(mp.get(3));
        //System.out.println(k);
    }
}
