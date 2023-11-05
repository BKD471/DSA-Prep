package dynamicp.stringss;

public class LongestCommonSubstring {
    public static int lcs(String str1, String str2){
        // Write your code here.
        int m=str1.length(),n=str2.length();
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++) dp[i][0]=0;
        for(int i=0;i<=n;i++) dp[0][i]=0;

        int mxLength=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    mxLength=Math.max(mxLength, dp[i][j]);
                }
            }
        }
        return mxLength;
    }
}
