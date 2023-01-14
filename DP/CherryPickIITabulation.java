public class CherryPickIITabulation {
    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = 0; col2 < n; col2++) {
                if (col1 == col2) dp[m - 1][col1][col2] = grid[m - 1][col1];
                else dp[m - 1][col1][col2] = grid[m - 1][col1] + grid[m - 1][col2];
            }
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = 0; col2 < n; col2++) {
                    int grandMax = Integer.MIN_VALUE;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int v = 0;
                            if (col1 == col2) v = grid[row][col1];
                            else v = grid[row][col1] + grid[row][col2];

                            if (col1 + i < n && col1 + i >= 0 && col2 + j >= 0 && col2 + j < n)
                                v += dp[row + 1][col1 + i][col2 + j];
                            else v = Integer.MIN_VALUE;
                            grandMax = Math.max(grandMax, v);
                        }
                    }
                    dp[row][col1][col2] = grandMax;
                }
            }
        }

        return dp[0][0][n - 1];
    }

    public static void main(String[] args) {
        int[][] grids={
                {3,1,1},{2,5,1},{1,5,5},{2,1,1}
        };
        System.out.println(CherryPickIITabulation.cherryPickup(grids));
    }
}

