import java.util.Arrays;

public class DistinctSubSeq {
    public int distinctSeq(String s1,String s2,int[][] memo,int m,int n){

        //if the second string exhausted that means we have matched
        if(n<0) return 1;
        //if second string is not exhauteed but we exhauted the search space that means no match
        if(m<0) return 0;

        if(memo[m][n]!=-1) return memo[m][n];
        if(s1.charAt(m)==s2.charAt(n)){
            memo[m][n]=distinctSeq(s1,s2,memo,m-1,n-1)+distinctSeq(s1,s2,memo,m-1,n);
            return memo[m][n];
        }else{
            memo[m][n]=distinctSeq(s1,s2,memo,m-1,n);
            return memo[m][n];
        }

    }
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();

        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);

        return distinctSeq(s,t,memo,m-1,n-1);
    }
}
