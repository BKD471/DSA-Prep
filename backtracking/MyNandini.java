package backtracking;

public class MyNandini {
    public int findMyNandini(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];

        dp[m-1][n-1]=grid[m-1][n-1]<0 ? (grid[m-1][n-1])*-1+1:1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                if(i==m-1){
                    int f=dp[i][j+1];
                    dp[i][j]=Math.max(1,f-grid[i][j]);
                }
                else if(j==n-1){
                    int f=dp[i+1][j];
                    dp[i][j]=Math.max(1,f-grid[i][j]);
                }else{
                    int f=Math.min(dp[i+1][j],dp[i][j+1]);
                    dp[i][j]=Math.max(1,f-grid[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
