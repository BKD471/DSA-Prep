import java.util.Arrays;

public class EditDistance {

    public int distance(String s,String s1,int m,int n,int[][] memo){
        //source string becomes exhausted so add everything in target string to become the target
        if(m<0) return n+1;

        //destination string becomes exhausted so delete everything remaining in source string
        // to become the target
        if(n<0) return m+1;

        if(memo[m][n]!=-1) return memo[m][n];

        if(s.charAt(m)==s1.charAt(n)){
            memo[m][n]=distance(s,s1,m-1,n-1,memo);
            return memo[m][n];
        }
        else{
            int replace=1+distance(s,s1,m-1,n-1,memo);
            int insert=1+distance(s,s1,m,n-1,memo);
            int delete=1+distance(s,s1,m-1,n,memo);
            memo[m][n]=Math.min(insert,Math.min(replace,delete));
            return memo[m][n];
        }
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();

        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);
        return distance(word1,word2,m-1,n-1,memo);
    }
}
