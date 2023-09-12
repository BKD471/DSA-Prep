package dynamicp;
import java.util.Arrays;
public class MaxPathSumInMatrix {
    private static int solve(int[][] grid,int i,int j,int m,int n,int[][] memo){

        if(i<0 || j<0 || i>=m || j>=n) return 0;

        if(i==m-1) return grid[i][j];

        if(memo[i][j]!=-1) return memo[i][j];
        int d= grid[i][j]+solve(grid,i+1,j,m,n,memo);
        int dl=grid[i][j]+solve(grid,i+1,j-1,m,n,memo);
        int dr=grid[i][j]+solve(grid,i+1,j+1,m,n,memo);

        memo[i][j]=Math.max(d,Math.max(dl,dr));
        return memo[i][j];
    }
    static int maximumPath(int N, int grid[][])
    {
        // code here

        int m=grid.length;
        int n=grid[0].length;

        int[][] memo=new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(memo[i],-1);
        int maxV=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) maxV=Math.max(maxV,solve(grid,0,i,m,n,memo));
        return maxV;
    }
}
