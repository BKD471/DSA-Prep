public class CountSubsetsWithSumKTabulation {
    public static int findWays(int nums[], int tar) {
        int n=nums.length;
        int[][] dp=new int[n][tar+1];

        for(int i=0;i<n;i++) dp[i][0]=1;
        if(nums[0]<=tar) dp[0][nums[0]]=1;

        //for handling 0 values
        if(nums[0]==0) dp[0][0]=2;
        for(int index=1;index<n;index++){
            for(int target=0;target<=tar;target++){
                int take=0;
                if(target>=nums[index]) take=dp[index-1][target-nums[index]];

                int no_take=dp[index-1][target];
                dp[index][target]=take+no_take;
            }
        }

        return dp[n-1][tar];
    }
}
