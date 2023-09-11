package dynamicp;
import java.util.Arrays;
public class UniquePathsII {
    private int solve(int[][] grid, int i, int j, int m, int n, int[][] memo) {
        if (i >= m || j >= n || grid[i][j] == 1) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (memo[i][j] != -1) return memo[i][j];
        int l = solve(grid, i, j + 1, m, n, memo);
        int r = solve(grid, i + 1, j, m, n, memo);
        memo[i][j] = l + r;
        return l + r;
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) Arrays.fill(memo[i], -1);
        return solve(grid, 0, 0, m, n, memo);
    }
}