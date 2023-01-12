import java.util.Arrays;

class Solution20 {
    public static int lookUp(int[][] grid,int[][] memo,int m,int n,int row,int col){

        if(row==m-1 && col==n-1){
            return grid[row][col];
        }


        if(memo[row][col]!=-1) return memo[row][col];

        int down=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(row<m-1 )down=grid[row][col]+lookUp(grid,memo,m,n,row+1,col);
        if(col<n-1) right=grid[row][col]+lookUp(grid,memo,m,n,row,col+1);

        memo[row][col]=Math.min(right,down);

        return memo[row][col];
    }

    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }

        return lookUp(grid,memo,m,n,0,0);

    }
}
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid={
                {2,3,5},
                {4,7,8},
                {2,1,5}
        };
        //2->4->2->1->5 =14
        System.out.println(Solution20.minPathSum(grid));
    }
}
