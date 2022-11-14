
import java.util.HashMap;

public class ArraySubset {

    public boolean subSetOfAnother(int[] nums, int[] subArray) {
        int n = nums.length;
        int m = subArray.length;
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hash.put(nums[i], 1);
        }

        for (int j = 0; j < m; j++) {
            if (!hash.containsKey(subArray[j])) return false;
        }

        return true;
    }
}


