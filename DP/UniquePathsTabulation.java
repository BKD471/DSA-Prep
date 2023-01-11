class Solution16 {
    public static long uniquePaths(int m, int n) {
        long[][] dp=new long[m][n];
        dp[0][0]=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0  && j==0) dp[i][j]=1;
                else{
                    long left=0;
                    long up=0;
                    if(i>0)  up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];

                    dp[i][j]=up+left;
                }
            }
        }

        return dp[m-1][n-1];
    }
}


public class UniquePathsTabulation {
    public static void main(String[] args) {
        int m=20,n=27;
        System.out.println(Solution16.uniquePaths(m,n));
    }
}
