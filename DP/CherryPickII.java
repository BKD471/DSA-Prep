class CherryPickII {
    public static int lookUp(int[][] grid,int row,int col1,int col2,int m,int n,int[][][] memo){
        if(row<0 || row>=m || col1<0 || col1>=n || col2>=n || col2<0) return Integer.MIN_VALUE;
        if(row==m-1){
            if(col1==col2) return grid[row][col2];  //check whther two robo standing on the same box
            return grid[row][col1]+grid[row][col2];
        }

        if(memo[row][col1][col2]!=-1) return memo[row][col1][col2];

        int grandMax=Integer.MIN_VALUE;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(col1==col2) grandMax=Math.max(grandMax,grid[row][col1]+lookUp(grid,row+1,col1+i,col2+j,m,n,memo));
                else   grandMax=Math.max(grandMax,grid[row][col1]+grid[row][col2]+lookUp(grid,row+1,col1+i,col2+j,m,n,memo));
            }
        }

        memo[row][col1][col2]=grandMax;
        return grandMax;

    }
    public static int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] memo=new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    memo[i][j][k]=-1;
                }
            }
        }
        return lookUp(grid,0,0,n-1,m,n,memo);
    }

    public static void main(String[] args) {
        int[][] grid={
                {3,1,1},
                {2,5,1},
                {1,5,5},
                {2,1,1} 
        };
        System.out.println(CherryPickII.cherryPickup(grid));
    }
}
