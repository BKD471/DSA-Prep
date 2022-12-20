import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static helper.CodeHelper.displayListOfList;

class Solution6 {
    public static void permutation(int[] nums, List<Integer> temp, List<List<Integer>> res, Map<Integer, Integer> mp) {
        if (temp.size() == nums.length) {
            //System.out.println(temp);
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (mp.get(nums[i]) == null) {
                mp.put(nums[i], 1);
                temp.add(nums[i]);
                permutation(nums, temp, res, mp);
                temp.remove(temp.size() - 1);
                mp.remove(nums[i]);
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        List<Integer> temp = new ArrayList<Integer>();
        permutation(nums, temp, res, mp);
        return res;
    }
}
public class PermutationLC46 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        List<List<Integer>> o = Solution6.permute(arr);
        displayListOfList(o);
    }
}
