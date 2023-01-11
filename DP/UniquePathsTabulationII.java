

class Solution18 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1) return 0;

        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0 ) dp[i][j]=1;
                else if( (i>0 || j>0) && obstacleGrid[i][j]==1) dp[i][j]=0;
                else{
                    int left=0;
                    int up=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }

        return dp[m-1][n-1];
    }
}



public class UniquePathsTabulationII {
    public static void main(String[] args) {
        int[][] paths={
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(Solution18.uniquePathsWithObstacles(paths));
    }
}
