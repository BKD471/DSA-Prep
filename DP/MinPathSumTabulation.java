
class Solution21 {
    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]=grid[i][j];
                else{
                    int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                    if(i>0) up=grid[i][j]+dp[i-1][j];
                    if(j>0) left=grid[i][j]+dp[i][j-1];

                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
public class MinPathSumTabulation {
    public static void main(String[] args) {
        int[][] grids={
                {2,4,7},
                {1,5,6},
                {3,2,1}
        };
        //2->1->3->2->1  --9
        System.out.println(Solution21.minPathSum(grids));
    }
}
