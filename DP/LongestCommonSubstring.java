public class LongestCommonSubstring {
    public static int lcs(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();


        int[][] dp=new int[m+1][n+1];

        int mx=Integer.MIN_VALUE;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    mx=Math.max(mx,dp[i][j]);
                }
                //this is very important
                //since this needs to be consecutive , we are not allowed to break and compare them ,
                // we cannot
                //depend on max of previous two steps,
                // it doesnot matter if they are unequal so put o
                else dp[i][j]=0;
            }
        }
        return mx==Integer.MIN_VALUE? 0:mx;

    }
}
