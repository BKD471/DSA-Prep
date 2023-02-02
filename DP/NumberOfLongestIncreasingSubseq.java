import java.util.Arrays;

public class NumberOfLongestIncreasingSubseq {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){

                //if we found a new lis
                if(nums[i]>nums[j] && 1+dp[j]>dp[i]){
                    dp[i]=dp[j]+1;
                    cnt[i]=cnt[j];
                }// if another lis found with same length update the cnt for the current
                else if(nums[j]<nums[i] && 1+dp[j]==dp[i]){
                    cnt[i]+=cnt[j];
                }
            }
        }

        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            mx=Math.max(mx,dp[i]);
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(dp[i]==mx) count+=cnt[i];
        }

        return count;
    }
}
