package dynamicp;

import java.util.Arrays;

public class Lcs {
    private int lcs(String s,String s1,int x,int y,int[][] dp){
        if(x>=s.length() || y>=s1.length()) return 0;
        if(dp[x][y]!=-1) return dp[x][y];
        if(s.charAt(x)==s1.charAt(y)) return 1+lcs(s,s1,x+1,y+1,dp);
        else dp[x][y]=Math.max( lcs(s,s1,x+1,y,dp),lcs(s,s1,x,y+1,dp));
        return dp[x][y];
    }

    public static void main(String[] args) {
        String s="nandini",s1="bhaskar";
        int[][] dp=new int[s.length()+1][s1.length()+1];
        for(int i=0;i<=s.length();i++) Arrays.fill(dp[i],-1);
        int res=new Lcs().lcs(s,s1,0,0,dp);
        System.out.println(res);
    }
}
