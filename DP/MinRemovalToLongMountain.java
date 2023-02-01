import java.util.Arrays;

public class MinRemovalToLongMountain {
    public int[] lis(int startIndex,int endIndex,int[] nums,int[] dp){
        int n=nums.length;
        int mx=Integer.MIN_VALUE;

        if(startIndex==0){
            //this is for frontLis
            for(int current=startIndex;current<endIndex;current++){
                for(int prev=startIndex;prev<current;prev++){
                    if(nums[current]>nums[prev] && 1+dp[prev]>dp[current]){
                        dp[current]=dp[prev]+1;
                    }
                }
            }
        }else{
            //this is for backLis
            for(int current=startIndex;current>=endIndex;current--){
                for(int prev=startIndex;prev>current;prev--){
                    if(nums[current]>nums[prev] && 1+dp[prev]>dp[current]){
                        dp[current]=dp[prev]+1;
                    }
                }
            }
        }

        return dp;
    }
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int[] frontLis=new int[n];
        int backLis[]=new int[n];

        Arrays.fill(frontLis,1);
        Arrays.fill(backLis,1);


        int[] frontLisDp=lis(0,n,nums,frontLis);
        int[] backLisDp=lis(n-1,0,nums,backLis);

        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(frontLisDp[i]!=1 && backLisDp[i]!=1){
                mx=Math.max(frontLisDp[i]+backLisDp[i]-1,mx);
            }
        }

        return n-mx;
    }
}
