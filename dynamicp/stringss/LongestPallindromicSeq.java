package dynamicp.stringss;

public class LongestPallindromicSeq {
    private static int solve(String s,String s2){
        int m = s.length(), n = s2.length();

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
    public static int longestPalindromeSubsequence(String s) {
        // Write your code here.
        StringBuilder sb=new StringBuilder(s);
        String t=sb.reverse().toString();
        return solve(s, t);
    }
}
