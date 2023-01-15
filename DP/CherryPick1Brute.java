import java.util.Arrays;

public class CherryPick1Brute {

        public static int lookUpLeft(int[][] grid,int row,int col,int m,int n){
            if(row==0 && col==0){
                return grid[row][col];
            }

            int up=Integer.MIN_VALUE,left=Integer.MIN_VALUE;

            if(grid[row][col]==-1) return (int)Math.pow(-10,9);
            //up
            if(row>0){
                int cherry=grid[row][col];
                grid[row][col]=0;
                up=cherry+lookUpLeft(grid,row-1,col,m,n);
                grid[row][col]=cherry;
            }

            //left
            if(col>0){
                int cherry=grid[row][col];
                grid[row][col]=0;
                left=cherry+lookUpLeft(grid,row,col-1,m,n);
                grid[row][col]=cherry;
            }

            return Math.max(up,left);
        }

        public static int lookUpRightDown(int[][] grid,int row,int col,int m,int n,int[][] memo){

            if(row==m-1 && col==n-1){
                int cherry=grid[row][col];
                grid[row][col]=0;
                int res=cherry+lookUpLeft(grid,m-1,n-1,m,n);
                grid[row][col]=cherry;
                return res;
            }

            int down=Integer.MIN_VALUE, right=Integer.MIN_VALUE;

            if(grid[row][col]==-1) return (int)Math.pow(-10,9);

            //if(memo[row][col]!=-1) return memo[row][col];
            //down
            if(row<m-1) {
                int cherry=grid[row][col];
                grid[row][col]=0;
                down=cherry+lookUpRightDown(grid,row+1,col,m,n,memo);
                grid[row][col]=cherry;
            }


            //right
            if(col<n-1) {
                int cherry=grid[row][col];
                grid[row][col]=0;
                right=cherry+lookUpRightDown(grid,row,col+1,m,n,memo);
                grid[row][col]=cherry;
            }

            return Math.max(down,right);
            //return memo[row][col];

        }

        public static int cherryPickup(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            if(grid[0][0]==-1) return 0;
            int[][] memo=new int[m][n];

            for(int i=0;i<m;i++){
                Arrays.fill(memo[i],-1);
            }

            int v=lookUpRightDown(grid,0,0,m,n,memo);
            return v<0 ? 0: v;
        }

    public static void main(String[] args) {
      int[][] grids={
              {0,1,-1},{1,0,-1},{1,1,1}};

        System.out.println(CherryPick1Brute.cherryPickup(grids));
    }
}
