import java.util.Arrays;

public class LisWithOneDarray {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int me=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) dp[i]=Math.max(dp[i],1+dp[j]);
                me=Math.max(me,dp[i]);
            }
        }
        return me;
    }
}
