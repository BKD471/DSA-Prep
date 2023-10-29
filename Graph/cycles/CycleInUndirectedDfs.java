package cycles;
import java.util.ArrayList;



public class CycleInUndirectedDfs {
    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj,
                                   boolean[] vis,int index,int parent){
        vis[index]=true;

        for(int t:adj.get(index)){
            if(!vis[t]){
                if(isCycle(adj,vis,t,index)==true) return true;
            }else if(parent!=t) return true;
        }

        return false;
    }
    public static String cycleDetection(int[][] edges, int v, int e) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=v;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u1=edges[i][0];
            int v1=edges[i][1];
            adj.get(u1-1).add(v1-1);
            adj.get(v1-1).add(u1-1);
        }


        boolean[] vis=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i] && isCycle(adj, vis, i,-1)) return "Yes";
        }
        return "No";

    }
}
