import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        Arrays.sort(nums);


        int[] tracker = new int[n];


        for (int i = 1; i < n; i++) {
            tracker[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
                    //System.out.println("egr");
                    dp[i] = 1 + dp[j];
                    tracker[i] = j;
                }
            }
        }

        int mxIndex = -1;
        int mx = -1;
        for (int i = 0; i < n; i++) {
            if (mx < dp[i]) {
                mx = dp[i];
                mxIndex = i;
            }
        }

        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[mxIndex]);
        while (tracker[mxIndex] != mxIndex) {
            int ind = tracker[mxIndex];
            temp.add(nums[ind]);
            mxIndex = ind;
        }
        Collections.reverse(temp);
        return temp;
    }
}
