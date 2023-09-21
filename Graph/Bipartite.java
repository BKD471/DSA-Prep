import  java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    private boolean dfs(int[][] grid,int[] colors,int index,int color){
        colors[index]=color;
        for(int t:grid[index]){
            if(colors[t]==-1){
                if(!dfs(grid, colors, t, 1 - color)) return false;
            }
            if(color==colors[t]) return false;
        }
        return true;
    }


    public boolean isBipartiteDfs(int[][] grid) {
        int m=grid.length;
        int v=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<grid[i].length;j++){
                v=Math.max(v,grid[i][j]);
            }
        }
        if(v==Integer.MIN_VALUE) return true;
        int[] colors=new int[v+1];
        Arrays.fill(colors,-1);
        for(int i=0;i<v;i++){
            if(colors[i]==-1 && !dfs(grid,colors,i,0)) return false;
        }
        return true;
    }


    //bfs
    private boolean bfs(int[][] grid,int[] color,int i){
        Queue<Integer> q=new LinkedList<>();
        q.offer(i);
        color[i]=0;

        while(!q.isEmpty()){
            int c=q.poll();
            for(int t:grid[c]){
                if(color[t]==-1){
                    color[t]=1-color[c];
                    q.offer(t);
                }
                if(color[t]==color[c]) return false;
            }
        }
        return true;
    }
    public boolean isBipartiteBfs(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int v = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                v = Math.max(v, grid[i][j]);
            }
        }

        if (v == Integer.MIN_VALUE) return true;

        int[] colors = new int[v + 1];
        Arrays.fill(colors, -1);
        for (int i = 0; i < v; i++) {
            if (colors[i] == -1 && !bfs(grid, colors, i)) return false;
        }
        return true;
    }
}
