package dynamicp.stringss;

public class PrintLcs {
    public static String findLCS(int m, int n, String s1, String s2){
        // Write your code here.
        if(m<=0 || n<=0) return "";
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][0]=0;
        for(int i=0;i<=n;i++) dp[0][i]=0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        if(dp[m][n]<=0) return "";
        int i=m,j=n;
        String res="";
        while(i>=0 && j>=0){
            if(s1.charAt(i)==s2.charAt(j)){
                res=s1.charAt(i)+res;
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]) i--;
            else j--;
        }
        return res;
    }
}
