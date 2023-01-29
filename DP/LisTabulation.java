public class LisTabulation {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

        int[][] dp=new int[n+1][n+1];

        for(int i=0;i<=n;i++) dp[n][i]=0;

        for(int index=n-1;index>=0;index--){
            for(int prev_index=index-1;prev_index>=-1;prev_index--){
                int not_take=dp[index+1][prev_index+1];
                int take=0;
                if(prev_index==-1 || nums[index]>nums[prev_index]) take=1+dp[index+1][index+1];
                dp[index][prev_index+1]=Math.max(not_take,take);
            }
        }
        return dp[0][0];
    }
}
