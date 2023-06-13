package DP;

import java.util.Arrays;



public class UniqUePathsIIMemoization {
    public static int lookUp(int row,int col,int[][] obstacleGrid,int[][] memo,int m,int n){
        if(memo[row][col]!=-1) return memo[row][col];

        if(row==m-1 && col==n-1){
            return 1;
        }


        int r=0,d=0;
        //Right
        if(col<n-1 && obstacleGrid[row][col+1]==0){
            r=lookUp(row,col+1,obstacleGrid,memo,m,n);
        }

        //Down
        if(row<m-1 && obstacleGrid[row+1][col]==0){
            d=lookUp(row+1,col,obstacleGrid,memo,m,n);
        }

        memo[row][col]=r+d;
        return r+d;

    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1) return 0;

        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return lookUp(0,0,obstacleGrid,memo,m,n);
    }
    public static void main(String[] args) {
        int[][] paths={
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(paths));
    }
}
