import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;


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



    //Kahn Approach   second way
    public List<Integer> eventualSafeNodesKahnWay(int[][] grid) {
        int m=grid.length;

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=m;i++) adj.add(new ArrayList<>());
        int[] inDegree=new int[m];
        for(int i=0;i<m;i++){
            int u=i;
            for(int j=0;j<grid[i].length;j++){
                int v=grid[i][j];
                adj.get(v).add(u);
                inDegree[u]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            if(inDegree[i]==0) q.offer(i);
        }

        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int t=q.poll();

            for(int i:adj.get(t)){
                inDegree[i]--;
                if(inDegree[i]==0) q.offer(i);
            }
            res.add(t);
        }
        Collections.sort(res);
        return res;
    }
}
