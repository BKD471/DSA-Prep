package dynamicp;

public class FrogJumpEasy {
    private static final int limit=(int)(Math.pow(10,9)+7);
    public static int countDistinctWayToClimbStair(long nStairs) {
        // Write your code here.
        if(nStairs==0) return 1;
        long[] dp=new long[(int)nStairs+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=nStairs;i++){
            dp[i]=(dp[i-1]%limit+dp[i-2]%limit)%limit;
        }
        return (int)dp[(int)nStairs];
    }
}
