package dynamicp.stringss;
import java.util.Arrays;
public class WildCards {
    private static boolean solve(String word1,String word2,int i,int j,Boolean[][] memo){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(i>=0 &&  j<0){
            for(int ind=0;ind<=i;ind++){
                if(word1.charAt(ind)!='*') return false;
            }
            return true;
        }
        if(memo[i][j]!=null) return memo[i][j];
        if(word1.charAt(i)==word2.charAt(j) || word1.charAt(i)=='?'){
            memo[i][j]=solve(word1, word2, i-1, j-1, memo);
            return memo[i][j];
        }
        if(word1.charAt(i)=='*'){
            memo[i][j]=solve(word1, word2, i-1, j, memo) || solve(word1, word2, i, j-1, memo);
            return memo[i][j];
        }
        return false;
    }
    public static boolean wildcardMatching(String word1, String word2) {
        // Write your code here.
        int m=word1.length(),n=word2.length();
        Boolean[][] memo=new Boolean[m+1][n+1];
        return solve(word1, word2, m-1, n-1, memo);

    }
}
