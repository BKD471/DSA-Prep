import java.util.Arrays;

public class MinOpsToTransformMemo {
    public static  int lcs(String s,String s1,int m,int n,int[][] memo){

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
    public static int canYouMake(String s, String s1) {
        // Write your code here.
        int m=s.length();
        int n=s1.length();

        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);

        int lc=lcs(s,s1,m-1,n-1,memo);
        return (m-lc)+(n-lc);

    }
}
