
import java.util.Arrays;
import java.util.ArrayList;

public class CycleDfs {

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj,int e,int parent,boolean[] vis){
        vis[e]=true;
        for(int t:adj.get(e)){
            if(!vis[t]){
                if(dfs(adj,t,e,vis)) return true;
            }
            else if(t!=parent) return true;
        }

        return false;
    }
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.

        boolean[] vis=new boolean[n+1];

        int a=edges.length;
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();


        for(int i=0;i<n+1;i++) res.add(new ArrayList<>());
        for(int i=0;i<a;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            res.get(u).add(v);
            res.get(v).add(u);
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(res,i,-1,vis)) return "Yes";
            }
        }
        return "No";
    }
}
