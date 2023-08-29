package dynamicp;

/*
c0=1
c1=1
c2=c0c1+c1c0
c3=c0c2+c1c1+c2c0
c4=c0c3+c1c2+c2c1+c3c0
c5=c0c4+c1c3+c2c2+c3c1+c4c0
 */

public class Catalan {
    private int limit=(int)(Math.pow(10,9)+7);
    public int numTrees(int n) {
        long[] dp=new long[n+2];

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                long t=((dp[j]%limit)*(dp[i-j-1]%limit))%limit;
                dp[i]=(dp[i]%limit+t)%limit;
            }
        }
        return (int)dp[n];
    }
}
