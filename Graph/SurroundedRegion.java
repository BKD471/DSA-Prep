public class SurroundedRegion {
        private void dfs(char[][] grid,int row,int col,int m,int n,boolean[][] vis){
            if(row<0 || col<0 || row>=m || col>=n || grid[row][col]=='X' || vis[row][col]) return;
            vis[row][col]=true;

            dfs(grid,row+1,col,m,n,vis);
            dfs(grid,row-1,col,m,n,vis);
            dfs(grid,row,col-1,m,n,vis);
            dfs(grid,row,col+1,m,n,vis);
        }
        public void solve(char[][] grid) {
            int m=grid.length,n=grid[0].length;
            boolean[][] vis=new boolean[m][n];

            for(int i=0;i<m;i++){
                if(grid[i][0]=='O') dfs(grid,i,0,m,n,vis);
                if(grid[i][n-1]=='O') dfs(grid,i,n-1,m,n,vis);
            }

            for(int i=0;i<n;i++){
                if(grid[0][i]=='O') dfs(grid,0,i,m,n,vis);
                if(grid[m-1][i]=='O') dfs(grid,m-1,i,m,n,vis);
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(!vis[i][j] && grid[i][j]=='O') grid[i][j]='X';
                }
            }
        }
}
