import java.util.Arrays;

public class NumOfIslands {
    public void lookUp(char[][] grid,boolean[][] visited,int row,int col,int m,int n){

        visited[row][col]=true;
        //UP
        if(row>0 && !visited[row-1][col] && grid[row-1][col]=='1'){
            lookUp(grid,visited,row-1,col,m,n);
        }

        //DOWN
        if(row<m-1 && !visited[row+1][col] && grid[row+1][col]=='1'){
            lookUp(grid,visited,row+1,col,m,n);
        }


        //Left
        if(col>0 && !visited[row][col-1] && grid[row][col-1]=='1'){
            lookUp(grid,visited,row,col-1,m,n);
        }

        //Right
        if(col<n-1 && !visited[row][col+1] && grid[row][col+1]=='1'){
            lookUp(grid,visited,row,col+1,m,n);
        }
    }

    public int solve(char[][] grid,boolean[][] visited,int cnt,int m,int n){

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    lookUp(grid,visited,i,j,m,n);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        for(boolean[] temp:visited){
            Arrays.fill(temp,false);
        }
        int cnt=0;
        return solve(grid,visited,cnt,m,n);
    }
}
