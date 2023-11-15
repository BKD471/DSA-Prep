package dynamicp.partitions;
import java.util.Arrays;
public class RodCuttingII {
    private int solve(int[] cuts,int i,int j,int[][] memo){
        if(i>j) return 0;

        int mn=Integer.MAX_VALUE;
        if(memo[i][j]!=-1) return memo[i][j];
        for(int k=i;k<=j;k++){
            int cost=cuts[j+1]-cuts[i-1]+solve(cuts,i,k-1,memo)+solve(cuts,k+1,j,memo);
            mn=Math.min(mn,cost);
        }

        return memo[i][j]=mn;
    }
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] res=new int[m+2];
        Arrays.sort(cuts);
        for(int i=1;i<=m;i++) res[i]=cuts[i-1];

        res[0]=0;
        res[m+1]=n;
        int[][] memo=new int[m+2][m+2];
        for(int i=0;i<m+2;i++) Arrays.fill(memo[i],-1);
        return solve(res,1,m,memo);

    }
}
