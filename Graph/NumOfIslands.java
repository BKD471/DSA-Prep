import java.util.Arrays;

public class NumOfIslands {
    private void dfs(char[][] grid,int i,int j,boolean[][] vis){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;
        vis[i][j]=true;

        //up
        if(i>0 && !vis[i-1][j] && grid[i][j]=='1') dfs(grid,i-1,j,vis);

        //down
        if(i+1<grid.length && !vis[i+1][j] && grid[i][j]=='1') dfs(grid,i+1,j,vis);

        //left
        if(j>0 && !vis[i][j-1] && grid[i][j]=='1') dfs(grid,i,j-1,vis);

        //right
        if(j+1<grid[0].length && !vis[i][j+1] && grid[i][j]=='1') dfs(grid,i,j+1,vis);
    }
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int c=0;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(grid,i,j,vis);
                    c++;
                }
            }
        }
        return c;
    }
}
