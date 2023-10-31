package cycles;

import java.util.ArrayList;

public class CycleInDirectedGraphDfs {
    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, boolean[] vis,
                                   int[] path, int node){
        vis[node]=true;
        path[node]=1;

        for(int t:adj.get(node)){
            if(!vis[t]){
                if(isCycle(adj, vis, path, t)) return true;
            }
            else if(path[t]==1) return true;
        }

        path[node]=0;
        return false;
    }
    public static boolean detectCycleInDirectedGraph(
            int n, ArrayList < ArrayList < Integer >> edges) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.size();i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            adj.get(u-1).add(v-1);
        }


        boolean[] vis=new boolean[n];
        int[] path=new int[n];
        for(int i=0;i<n;i++){
            if(!vis[i] && isCycle(adj,vis,path,i)) return true;
        }
        return false;
    }
}
