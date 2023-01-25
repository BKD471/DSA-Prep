public class EditDistanceTabulation {
    public int minDistance(String word1, String word2) {

        int m=word1.length();
        int n=word2.length();

        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++) dp[i][0]=i;
        for(int i=1;i<=n;i++) dp[0][i]=i;

        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(word1.charAt(index1-1)==word2.charAt(index2-1)) dp[index1][index2]=dp[index1-1][index2-1];
                else{

                    int insert=1+dp[index1][index2-1];
                    int delete=1+dp[index1-1][index2];
                    int replace=1+dp[index1-1][index2-1];
                    dp[index1][index2]=Math.min(insert,Math.min(delete,replace));
                }
            }
        }
        return dp[m][n];
    }
}
