package dynamicp;
import java.util.Arrays;
public class MinPathSum {
    private int solve(int[][] grid,int i,int j,int m,int n,int[][] memo){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return grid[i][j];
        if(memo[i][j]!=-1) return memo[i][j];
        int l=Integer.MAX_VALUE,r=Integer.MAX_VALUE;
        if(j+1<n) l=grid[i][j]+solve(grid,i,j+1,m,n,memo);
        if(i+1<m) r=grid[i][j]+solve(grid,i+1,j,m,n,memo);
        memo[i][j]=Math.min(l,r);
        return memo[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] memo=new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(memo[i],-1);
        return solve(grid,0,0,m,n,memo);
    }
}
