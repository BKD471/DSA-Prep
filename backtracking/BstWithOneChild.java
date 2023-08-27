package backtracking;

import java.util.ArrayList;

public class BstWithOneChild {
    public String solve(ArrayList<Integer> arr) {
        int n = arr.size();

        int max_val = Integer.MAX_VALUE, min_val = Integer.MIN_VALUE; // initialize max and min to extreme values
        for (int i = 1; i < n; i++) {
            if (arr.get(i) < min_val || arr.get(i) > max_val) {
                return "NO";
            }
            if (arr.get(i) < arr.get(i - 1)) {
                max_val = arr.get(i - 1);
            } else {
                min_val = arr.get(i - 1);
            }
        }
        return "YES";
    }
}
