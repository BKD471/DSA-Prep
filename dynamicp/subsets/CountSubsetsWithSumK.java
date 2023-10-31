package dynamicp.subsets;
import java.util.Arrays;

public class CountSubsetsWithSumK {
    private static final int limit=(int)(Math.pow(10,9)+7);
    private static int solve(int[] nums, int index, int v, int[][] memo) {
        if(index==nums.length-1){
            if(v==0 && nums[index]==0) return 2;
            if(v==0 || nums[index]==v) return 1;
            return 0;
        }

        if(memo[index][v]!=-1) return memo[index][v];
        int take=0;
        if(v>=nums[index]) take=solve(nums, index+1, v-nums[index], memo);
        int not_take=solve(nums, index+1, v, memo);
        memo[index][v]=(take%limit+not_take%limit)%limit;
        return memo[index][v];
    }
    public static int findWays(int nums[], int v) {
        // Write your code here.
        int n=nums.length;
        int[][] memo = new int[n + 1][v + 1];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return solve(nums, 0, v, memo);
    }
}
