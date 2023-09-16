public class NumOfProvinces {
    private void dfs(int[][] grid,int i,int j,boolean[][] vis,int targetColor,int baseColor){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;
        vis[i][j]=true;
        grid[i][j]=targetColor;
        //up
        if(i>0 && !vis[i-1][j] && grid[i-1][j]==baseColor) dfs(grid,i-1,j,vis,targetColor,baseColor);

        //down
        if(i+1<grid.length && !vis[i+1][j] && grid[i+1][j]==baseColor) dfs(grid,i+1,j,vis,targetColor,baseColor);

        //left
        if(j>0 && !vis[i][j-1] && grid[i][j-1]==baseColor) dfs(grid,i,j-1,vis,targetColor,baseColor);

        //right
        if(j+1<grid[0].length && !vis[i][j+1] && grid[i][j+1]==baseColor) dfs(grid,i,j+1,vis,targetColor,baseColor);
    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int m=grid.length,n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        if(sr<0 || sc<0 || sr>=m || sc>=n) return grid;

        int baseColor=grid[sr][sc];
        dfs(grid,sr,sc,vis,color,baseColor);
        return grid;
    }
}
