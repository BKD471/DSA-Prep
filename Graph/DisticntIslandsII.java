import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



public class DisticntIslandsII {
    private static void dfs(int[][] grid, int row, int col,
                            int m, int n, boolean[][] vis, int row0, int col0, ArrayList<String> res){
        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]==0 || vis[row][col]) return;
        vis[row][col]=true;
        res.add(String.format("%s->%s",row-row0,col-col0));
        dfs(grid,row-1,col,m,n,vis,row0,col0,res);
        dfs(grid,row+1,col,m,n,vis,row0,col0,res);
        dfs(grid,row,col+1,m,n,vis,row0,col0,res);
        dfs(grid,row,col-1,m,n,vis,row0,col0,res);
    }


    public static int distinctIsland(int [][] grid,int m,int n)
    {
        //write your code here
        boolean[][] vis=new boolean[m][n];

        Set<ArrayList<String>> st=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1) {
                    ArrayList<String> res=new ArrayList<>();
                    dfs(grid,i,j,m,n,vis,i,j,res);
                    st.add(res);
                }
            }
        }
        return st.size();
    }
}
