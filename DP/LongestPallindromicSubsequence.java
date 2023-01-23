import java.util.Arrays;

public class LongestPallindromicSubsequence {
    public  int lcs(String s,String s1,int m,int n,int[][] memo){

        if(m<0 || n<0) return 0;

        if(memo[m][n]!=-1) return memo[m][n];

        if(s.charAt(m)==s1.charAt(n)){
            memo[m][n]=1+lcs(s,s1,m-1,n-1,memo);
            return memo[m][n];
        }
        else{
            memo[m][n]=Math.max(lcs(s,s1,m-1,n,memo),lcs(s,s1,m,n-1,memo));
            return memo[m][n];
        }
    }
    public int longestPalindromeSubseq(String s) {
        //find lcs between the string and its reversed version
        //this will guratee that lcs between them is always a pallindrome
        //such a cynical idea :)
        StringBuilder sb=new StringBuilder(s);
        String s1=sb.reverse().toString();

        int[][] memo=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) Arrays.fill(memo[i],-1);

        return lcs(s,s1,s.length()-1,s1.length()-1,memo);
    }
}
