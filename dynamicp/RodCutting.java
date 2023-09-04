package dynamicp;

import java.util.Arrays;

public class RodCutting {
    private int maximize(int n,int[] dp){
        if(n==0 || n==1) return 0;
        if(dp[n]!=-1) return dp[n];
        int mxv=0;
        for(int i=1;i<=n;i++){
            mxv=Math.max(mxv, Math.max(i*maximize(n-i,dp),i*(n-i)));
        }
        dp[n]=mxv;
        return mxv;
    }
    public static void main(String[] args) {
        RodCutting rd=new RodCutting();
        int[] dp=new int[10+1];
        Arrays.fill(dp,-1);
        int res=rd.maximize(10,dp);
        System.out.println(res);
    }
}
