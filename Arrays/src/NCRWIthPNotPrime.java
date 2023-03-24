public class NCRWIthPNotPrime {
    public int solve(int n, int r, int p) {
        int[][] dp=new int[n+1][r+1];

        for(int i=0;i<=n;i++) dp[i][0]=1;
        for(int i=0;i<=r;i++) dp[i][i]=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=r;j++){
                int res=(dp[i-1][j-1]%p+dp[i-1][j]%p)%p;
                dp[i][j]=res;
            }
        }

        return dp[n][r];
    }
}
