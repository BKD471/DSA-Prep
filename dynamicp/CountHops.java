package dynamicp;

import java.util.Arrays;
import java.util.Collections;

public class CountHops {
    private static final int LIMIT=(int)(Math.pow(10,9)+7);
    private long countHops(int n,long[] dp){
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        dp[n]=(countHops(n-3,dp)%LIMIT+countHops(n-2,dp)%LIMIT+countHops(n-1,dp)%LIMIT)%LIMIT;
        return dp[n];
    }
    public static void main(String[] args) {
        CountHops cp=new CountHops();
        int n=54;
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        int op=(int)cp.countHops(n,dp);
        System.out.println(op);
    }
}
