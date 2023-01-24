public class DistinctSubSeqTabulation {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();

        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++) dp[i][0]=1;
        for(int j=1;j<=n;j++) dp[0][j]=0;

        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(s.charAt(index1-1)==t.charAt(index2-1)) dp[index1][index2]=dp[index1-1][index2-1]+dp[index1-1][index2];
                else dp[index1][index2]=dp[index1-1][index2];
            }
        }
        return dp[m][n];
    }
}
