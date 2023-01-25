public class WildCardTabulation {
    public int checkStar(String s,int i){
        for(int j=1;j<=i;j++) if(s.charAt(j-1)!='*') return 0;
        return 1;
    }
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();

        int[][] dp=new int[m+1][n+1];

        //both strigs exhausted
        dp[0][0]=1;

        //if string1  gets exhausted  and string2 is still left then it will only give true iff string2 has all
        //because its only * that can match with null
        for(int i=1;i<=n;i++){
            dp[0][i]=checkStar(p,i);
        }

        //if string1 is still left and string2 exhausted that means there are still charcters left unmatched
        for(int i=1;i<=m;i++) dp[i][0]=0;

        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(s.charAt(index1-1)==p.charAt(index2-1) || p.charAt(index2-1)=='?') dp[index1][index2]=dp[index1-1][index2-1];
                else if(p.charAt(index2-1)=='*') dp[index1][index2]=dp[index1-1][index2] | dp[index1][index2-1];
                else dp[index1][index2]=0;
            }
        }
        return dp[m][n]==1? true:false;

    }
}
