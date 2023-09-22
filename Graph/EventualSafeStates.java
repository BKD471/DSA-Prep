import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {
    private boolean dfs(int[][]  grid,int[] vis,int[] path,int index){
        vis[index]=1;
        path[index]=1;

        for(int t:grid[index]){
            if(vis[t]==0 && dfs(grid,vis,path,t)) return true;
            else if(vis[t]==1 && path[t]==1) return true;
        }

        path[index]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m=graph.length;

        int[] vis=new int[m];
        int[] path=new int[m];


        for(int i=0;i<m;i++){
            if(vis[i]==0) dfs(graph,vis,path,i);
        }

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<m;i++) {
            if(path[i]==0) res.add(i);
        }
        return res;
    }
}
