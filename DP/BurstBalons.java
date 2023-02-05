public class BurstBalons {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] ballons=new int[n+2];
        for(int i=0;i<n;i++) ballons[i+1]=nums[i];
        ballons[0]=1;
        ballons[n+1]=1;

        int[][] dp=new int[n+2][n+2];

        for(int start=n;start>=1;start--){
            for(int end=1;end<=n;end++){
                int mxCoins=-(int)Math.pow(10,9);
                if(start>end) continue;
                for(int k=start;k<=end;k++){
                    int coins=ballons[start-1]*ballons[k]*ballons[end+1]+dp[start][k-1]+dp[k+1][end];
                    mxCoins=Math.max(coins,mxCoins);
                }
                dp[start][end]=mxCoins;
            }
        }
        return dp[1][n];
    }
}
