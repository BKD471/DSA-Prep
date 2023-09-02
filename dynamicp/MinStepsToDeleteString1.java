package dynamicp;
import java.util.Arrays;
public class MinStepsToDeleteString1 {
    private int calMinOps(String s,int[][] memo,int i,int e){
        if(i>e) return 0;
        if(i==e) return 1;

        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        int c=Integer.MAX_VALUE;

        if(memo[i][e]!=-1) return memo[i][e];

        a=1+calMinOps(s,memo,i+1,e);
        if(s.charAt(i)==s.charAt(i+1)) b=1+calMinOps(s,memo,i+2,e);
        for(int indx=i+2;indx<=e;indx++){
            if(s.charAt(i)==s.charAt(indx)) c=Math.min(c,
                    calMinOps(s,memo,i+1,indx-1)+calMinOps(s,memo,indx+1,e));
        }

        memo[i][e]=Math.min(a,Math.min(b,c));
        return memo[i][e];
    }

    public int minStepToDeleteString(String s)
    {
        // Your code goes here
        int n=s.length();
        int[][] memo=new int[n+1][n+1];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
        return calMinOps(s,memo,0,n-1);
    }
}
