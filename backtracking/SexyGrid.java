package backtracking;

public class SexyGrid {
    private int findMyWay(int[][] grid,int row,int col,int m,int n){
        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]==1) return 0;
        if(row==m-1 && col==n-1) return 1;

        int d=0,r=0;
        //down
        d=findMyWay(grid,row+1,col,m,n);

        //right
        r=findMyWay(grid,row,col+1,m,n);

        return r+d;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;
        return findMyWay(grid,0,0,m,n);
    }
}
