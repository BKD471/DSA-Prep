package dynamicp;
import java.util.Arrays;
public class MinOps {
    public int solve(int n,int[] dp){
        if(n<=0) return 0;
        if(dp[n]!=-1) return dp[n];
        int l=Integer.MAX_VALUE;
        int r=Integer.MAX_VALUE;
        if(n%2==0) r=1+solve(n/2,dp);
        else l=1+solve(n-1,dp);
        dp[n]=Math.min(l,r);
        return dp[n];
    }
    public int minOperation(int n)
    {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}
