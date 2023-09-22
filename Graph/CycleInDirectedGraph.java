import java.util.ArrayList;

public class CycleInDirectedGraph {
    private static boolean dfs(ArrayList<ArrayList<Integer>> adj,
                               int[] vis,int[] path,int index){
        if(index>=adj.size()) return false;
        vis[index]=1;
        path[index]=1;

        for(int t:adj.get(index)){
            if(vis[t]==0 && dfs(adj,vis,path,t)) return true;
            else if(vis[t]==1 && path[t]==1) return true;
        }
        path[index]=0;
        return false;
    }

    public static boolean
    detectCycleInDirectedGraph(int n,
                               ArrayList < ArrayList < Integer >> grid) {
        // Write your code here.
        int m=grid.size();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u=grid.get(i).get(0);
            int v=grid.get(i).get(1);
            adj.get(u).add(v);
        }

        int[] vis=new int[n+1];
        int[] path=new int[n+1];

        for(int i=1;i<=n;i++){
            if(vis[i]==0 && dfs(adj,vis,path,i)) return true;
        }
        return false;
    }
}
