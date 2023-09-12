package dynamicp;


public class MinFallingPathSum {
    private int solve(int[][] grid,int i,int j,int n,Integer[][] memo){
        if(i==n-1) return grid[i][j];

        if(memo[i][j]!=null) return memo[i][j];

        int d=Integer.MAX_VALUE;
        if(i+1<n) d=grid[i][j]+solve(grid,i+1,j,n,memo);

        int dl=Integer.MAX_VALUE;
        if(i+1<n && j>0) dl=grid[i][j]+solve(grid,i+1,j-1,n,memo);

        int dr=Integer.MAX_VALUE;
        if(i+1<n && j+1<n) dr=grid[i][j]+solve(grid,i+1,j+1,n,memo);
        return Math.min(d,Math.min(dl,dr));
    }
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;

        Integer[][] memo=new Integer[n][n];
        int minV=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) minV=Math.min(minV,solve(grid,0,i,n,memo));
        return minV;
    }
}
