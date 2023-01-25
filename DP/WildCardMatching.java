import java.util.Arrays;

public class WildCardMatching {
    public int wild(String a,String b,int m,int n,int[][] memo){
        //if both gets exhausted
        if(m<0 && n<0) return 1;

        //if string1  gets exhausted  and string2 is still left then it will only give true iff string2 has all *
        //because its only * that can match with null
        if(m<0 && n>=0){
            for(int i=0;i<=n;i++) if(b.charAt(i)!='*') return 0;
            return 1;
        }

        //if string1 is still left and string2 exhausted that means there are still charcters left unmatched
        if(n<0 && m>=0) return 0;
        if(memo[m][n]!=-1) return memo[m][n];

        if(a.charAt(m)==b.charAt(n) || b.charAt(n)=='?') {
            memo[m][n]=wild(a,b,m-1,n-1,memo);
            return memo[m][n];
        }
        else if(b.charAt(n)=='*'){
            memo[m][n]=wild(a,b,m-1,n,memo) | wild(a,b,m,n-1,memo);
            return memo[m][n];
        }
        else memo[m][n]=0;

        return memo[m][n];
        // return false;
    }
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);
        return  wild(s,p,m-1,n-1,memo)==1? true: false;
    }
}
