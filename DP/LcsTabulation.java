public class LcsTabulation {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int p=text2.length();

        //In order to convert to tabulation and follow the memoization base case
        //lets shift the indexes to right by 1
        //that means i-> i-1   j->j-1   -1->0  , m-1>m
        int[][] dp=new int[n+1][p+1];

        for(int i=0;i<n;i++) dp[i][0]=0;
        for(int j=0;j<p;j++) dp[0][j]=0;


        for(int index1=1;index1<=n;index1++){
            for(int index2=1;index2<=p;index2++){
                if(text1.charAt(index1-1)==text2.charAt(index2-1)){
                    dp[index1][index2]=1+dp[index1-1][index2-1];
                }else{
                    dp[index1][index2]=Math.max( dp[index1-1][index2],dp[index1][index2-1]);
                }
            }
        }

        return dp[n][p];
    }
}
