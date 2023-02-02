import java.util.Arrays;

public class LongestContinuousIncSubseq {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]>nums[i-1] && dp[i-1]+1>dp[i]){
                dp[i]=1+dp[i-1];
                mx=Math.max(dp[i],mx);
            }
        }

        return mx!=Integer.MIN_VALUE ? mx:1;
    }
}
