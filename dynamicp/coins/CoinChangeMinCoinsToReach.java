package dynamicp.coins;

import java.util.Arrays;
public class CoinChangeMinCoinsToReach {
    private static final int limit = (int) (Math.pow(10, 9) + 7);

    private static long solve(int[] nums, int index, int v, long[][] memo) {
        if (index == nums.length - 1) {
            if ((v % nums[index]) == 0) return v / nums[index];
            else return limit;
        }

        if (memo[index][v] != -1) return memo[index][v];
        long take = limit;
        if (nums[index] <= v) take = 1 + solve(nums, index, v - nums[index], memo);
        long not_take = solve(nums, index + 1, v, memo);
        memo[index][v] = Math.min(take, not_take);
        return memo[index][v];
    }

    public int coinChange(int[] nums, int v) {
        int n = nums.length;
        long[][] memo = new long[n + 1][v + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(memo[i], -1);
        int res = (int) solve(nums, 0, v, memo);
        return res == limit ? -1 : res;
    }
}
