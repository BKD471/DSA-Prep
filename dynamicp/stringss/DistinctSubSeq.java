package dynamicp.stringss;
import java.util.Arrays;
public class DistinctSubSeq {
    private static final int limit=(int)(Math.pow(10,9)+7);
    private static int solve(String s,String s1,int i,int j,int[][] memo){
        if(j<0) return 1;
        if(i<0 && j>=0) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        if(s.charAt(i)==s1.charAt(j)){
            memo[i][j]=(solve(s, s1, i-1, j-1,memo)%limit+solve(s, s1, i-1, j,memo)%limit)%limit;
            return memo[i][j];
        }else{
            memo[i][j]=solve(s, s1, i-1, j,memo)%limit;
            return memo[i][j];
        }

    }


    public static int distinctSubsequences(String str, String sub) {
        // Write your code here.
        int m=str.length(),n=sub.length();
        int[][] memo=new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(memo[i],-1);
        return solve(str,sub,m-1,n-1,memo);
    }
}
