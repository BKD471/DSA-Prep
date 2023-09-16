package dynamicp;

public class ArrayPartitionWithMinAbsDifference {
    private static void solve(int[] nums,boolean[][] dp,int sum){
        for(int i=0;i<nums.length;i++) dp[i][0]=true;
        if(nums[0]<=sum) dp[0][nums[0]]=true;

        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=sum;j++){
                Boolean take=false;
                if(j>=nums[i]) take=dp[i-1][j-nums[i]];
                boolean non_take=dp[i-1][j];

                dp[i][j]=take || non_take;
            }
        }
    }
    public static int minSubsetSumDifference(int []nums, int n) {
        int sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];
        boolean[][] dp=new boolean[n+1][sum+1];

        solve(nums,dp,sum);

        int mn=Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(dp[n-1][i]){
                int sum1=i;
                int sum2=sum-sum1;
                mn=Math.min(mn,Math.abs(sum1-sum2));
            }
        }
        return mn;
    }
}
