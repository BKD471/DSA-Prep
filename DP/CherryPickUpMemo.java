import java.util.Arrays;

public class CherryPickUpMemo {

        public static int lookRightDown(int[][] grid,int row1,int col1,int row2,int col2,int n,int[][][][] memo){


            if(row1==n-1 && col1==n-1){
                return grid[row1][col1];
            }

            if(grid[row1][col1]==-1 || grid[row2][col2]==-1) return Integer.MIN_VALUE;

            if(memo[row1][col1][row2][col2]!=-1) return memo[row1][col1][row2][col2];

            int rr=Integer.MIN_VALUE,dd=Integer.MIN_VALUE,rd=Integer.MIN_VALUE,dr=Integer.MIN_VALUE;

            //Instead of goin and returning, send two players instead from (0,0) to (n-1,n-1)
            //There will be four state (Right Right)  (Down Down)  (Down Right) (Right DOwn)
            //Return the max collected by both of them together

            //right right
            if(col1<n-1 && col2<n-1){
                if(row1==row2 && col1==col2){
                    rr=grid[row1][col1]+lookRightDown(grid,row1,col1+1,row2,col2+1,n,memo);
                }
                else
                {
                    rr=grid[row1][col1]+grid[row2][col2]+lookRightDown(grid,row1,col1+1,row2,col2+1,n,memo);
                }
            }

            //down down
            if(row1<n-1 && row2<n-1){
                if(row1==row2 && col1==col2){
                    dd=grid[row1][col1]+lookRightDown(grid,row1+1,col1,row2+1,col2,n,memo);
                }else{
                    dd=grid[row1][col1]+grid[row2][col2]+lookRightDown(grid,row1+1,col1,row2+1,col2,n,memo);
                }
            }

            //down right
            if(row1<n-1 && col2<n-1){
                if(row1==row2 && col1==col2){
                    dr=grid[row1][col1]+lookRightDown(grid,row1+1,col1,row2,col2+1,n,memo);
                }else{
                    dr=grid[row1][col1]+grid[row2][col2]+lookRightDown(grid,row1+1,col1,row2,col2+1,n,memo);
                }
            }

            //right down
            if(col1<n-1 && row2<n-1){
                if(row1==row2 && col1==col2){
                    rd=grid[row1][col1]+lookRightDown(grid,row1,col1+1,row2+1,col2,n,memo);
                }else{
                    rd=grid[row1][col1]+grid[row2][col2]+lookRightDown(grid,row1,col1+1,row2+1,col2,n,memo);
                }
            }

            memo[row1][col1][row2][col2]=Math.max( Math.max(rr,rd),Math.max(dd,dr));
            return memo[row1][col1][row2][col2];
        }

        public static int cherryPickup(int[][] grid) {
            int n=grid.length;
            if(grid[0][0]==-1) return 0;
            int[][][][] memo=new int[n][n][n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        Arrays.fill(memo[i][j][k],-1);
                    }
                }
            }

            int v=lookRightDown(grid,0,0,0,0,n,memo);
            return v<0 ? 0: v;
        }

    public static void main(String[] args) {
            int[][] grid={
                    {0,1,-1},
                    {1,0,-1},
                    {1,1,1}
            };
        System.out.println(CherryPickUpMemo.cherryPickup(grid));
    }
}
