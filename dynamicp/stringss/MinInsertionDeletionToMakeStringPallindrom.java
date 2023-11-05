package dynamicp.stringss;

public class MinInsertionDeletionToMakeStringPallindrom {
    private static int solve(String s,String s2){
        int m = s.length(), n = s2.length();
        if(m<=0 || n<=0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = 0;
        for (int i = 0; i <= n; i++) dp[0][i] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    public static int canYouMake(String s1, String s2) {
        // Write your code here.
        int mxLength=solve(s1, s2);
        return s1.length()-mxLength+s2.length()-mxLength;
    }
}
