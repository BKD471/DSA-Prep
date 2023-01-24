public class ShortestCommonSuperSequence {
    public String shortestCommonSupersequence(String str1, String str2) {

        int m=str1.length();
        int n=str2.length();

        int[][] dp=new int[m+1][n+1];



        for(int i=0;i<=m;i++) dp[i][0]=0;
        for(int j=1;j<=n;j++)  dp[0][j]=0;

        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(str1.charAt(index1-1)==str2.charAt(index2-1)) dp[index1][index2]=1+dp[index1-1][index2-1];
                else dp[index1][index2]=Math.max(dp[index1][index2-1],dp[index1-1][index2]);
            }
        }



        int i=m,j=n;
        String res="";
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                res+=str2.charAt(j-1);
                i=i-1;
                j=j-1;
            }else{

                int up=dp[i-1][j];
                int left=dp[i][j-1];

                if(up>left){
                    res+=str1.charAt(i-1);
                    i=i-1;
                    j=j;
                }else{
                    res+=str2.charAt(j-1);
                    i=i;
                    j=j-1;
                }
            }
        }

        while(i>0){
            res+=str1.charAt(i-1);
            i--;
        }

        while(j>0){
            res+=str2.charAt(j-1);
            j--;
        }
        StringBuilder sb=new StringBuilder(res);
        return sb.reverse().toString();
    }
}
