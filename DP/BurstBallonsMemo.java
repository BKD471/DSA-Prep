import java.util.Arrays;

public class BurstBallonsMemo {
    public int burst(int[] ballons,int start,int end,int[][] memo){
        if(start>end) return 0;

        if(memo[start][end]!=-1) return memo[start][end];
        int mxCoins=-(int)Math.pow(10,9);
        for(int k=start;k<=end;k++){
            int coins=ballons[start-1]*ballons[k]*ballons[end+1]+burst(ballons,start,k-1,memo)+burst(ballons,k+1,end,memo);
            mxCoins=Math.max(coins,mxCoins);
        }

        return memo[start][end]=mxCoins;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] ballons=new int[n+2];
        for(int i=0;i<n;i++) ballons[i+1]=nums[i];
        ballons[0]=1;
        ballons[n+1]=1;

        int[][] memo=new int[n+1][n+1];
        for(int i=0;i<n+1;i++) Arrays.fill(memo[i],-1);
        return burst(ballons,1,n,memo);
    }
}
