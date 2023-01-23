public class MinInsertionsToMakePallinTabulation {
    public int minInsertions(String s) {

        //approach always keep the longest pallindromic subsq constant
        //because they are already pallindrome
        // pick the rest , reverse it and add
        //since we are adding the rest of string so it will be the answer

        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        String ss=sb.reverse().toString();

        int[][] dp=new int[n+1][n+1];

        for(int i=0;i<n;i++) dp[0][i]=0;
        for(int j=0;j<n;j++) dp[j][0]=0;


        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==ss.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        //lcs give sthe count of longest pallindrome subseq already present
        //total length-that count  will give the no of additions needed to be done
        return n-dp[n][n];
    }
}
