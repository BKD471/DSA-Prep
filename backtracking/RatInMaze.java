package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInMaze {
    int count=0;
    private void findPath(int[][] grid,int row,int col,int m,int n,int zeros,int curr){
        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]==-1) return;

        if(grid[row][col]==2 && zeros==curr) {
            count++;
            return;
        }

        if(grid[row][col]==0) {
            grid[row][col] = 47;
            //up
            findPath(grid, row - 1, col, m, n, zeros, curr + 1);
            //down
            findPath(grid, row + 1, col, m, n, zeros, curr + 1);
            //left
            findPath(grid, row, col - 1, m, n, zeros, curr + 1);
            //right
            findPath(grid, row, col + 1, m, n, zeros, curr + 1);
            grid[row][col] = 0;
        }

    }
    public int solve(int[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;

        int zeros=0,row=-1,col=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 ) zeros++;
                if(grid[i][j]==1){
                    row=i;
                    col=j;
                }
            }
        }

        count=0;
        grid[row][col]=0;
        findPath(grid,row,col,m,n,zeros,-1);
        return count;
    }

    public static void main(String[] args) {
        RatInMaze ratInMaze=new RatInMaze();
        int[][] res={{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        ratInMaze.solve(res);
        System.out.println(ratInMaze.count);
    }
}
