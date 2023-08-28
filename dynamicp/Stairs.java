package dynamicp;
import java.util.Arrays;
public class Stairs {
    private  int limit=(int)(Math.pow(10,9)+7);
    private int countWays(int n,int[] dp){
        if(n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        dp[n]=(countWays(n-1,dp)%limit+countWays(n-2,dp)%limit)%limit;
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return countWays(n,dp);
    }
}
