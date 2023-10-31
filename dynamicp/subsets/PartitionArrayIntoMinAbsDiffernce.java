package dynamicp.subsets;

public class PartitionArrayIntoMinAbsDiffernce {
    private static boolean[][] solve(int[] nums, int target, boolean[][] memo) {
        int n=nums.length;
        for(int i=0;i<n;i++) memo[i][0]=true;
        if(nums[0]<=target) memo[0][nums[0]]=true;

        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean take=false;
                take=false;
                if(j>=nums[i]) take=memo[i-1][j-nums[i]];
                boolean non_take=memo[i-1][j];
                memo[i][j]=take|| non_take;
            }
        }
        return memo;
    }
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        boolean[][] memo=new boolean[n+1][(int)sum+1];
        boolean[][] dp=solve(arr,(int)sum,memo);

        int res=Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(!dp[n - 1][i]) continue;
            int s1=i;
            int s2=(int)sum-s1;
            res=Math.min(res,Math.abs(s1-s2));
        }
        return res;
    }
}
