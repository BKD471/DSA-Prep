public class LongestPallindromicSeqTabulation {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        String s1=sb.reverse().toString();

        int n=s.length();
        int[][] dp=new int[n+1][n+1];

        for(int i=0;i<n;i++) dp[i][0]=0;
        for(int j=0;j<n;j++) dp[0][j]=0;

        for(int index=1;index<=n;index++){
            for(int index1=1;index1<=n;index1++){
                if(s.charAt(index-1)==s1.charAt(index1-1)) dp[index][index1]=1+dp[index-1][index1-1];
                else dp[index][index1]=Math.max(dp[index-1][index1],dp[index][index1-1]);
            }
        }

        return dp[n][n];
    }
}
