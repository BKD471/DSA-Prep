public class MinOpsToTransform {

    public int minOps(String s, String s1) {


        int m = s.length();
        int n = s1.length();


        //To tansform one string to another
        //first calculate the common portion/ longest common subseq between them
        // that will be constant , subtract it from two  to get the final amnt
        //GENIUS :)
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) dp[i][0] = 0;
        for (int j = 0; j < n; j++) dp[0][j] = 0;


        for (int index1 = 1; index1 <= m; index1++) {
            for (int index2 = 1; index2 <= n; index2++) {
                if (s.charAt(index1 - 1) == s1.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        return (m - dp[m][n]) + (n - dp[m][n]);
    }
}
