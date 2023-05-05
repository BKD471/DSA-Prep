import java.util.ArrayList;

public class Dfs {
    public void dfs(ArrayList<Integer> res, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int indx){
        vis[indx]=true;
        res.add(indx);
        for(Integer i:adj.get(indx)){
            if(!vis[i]){
                dfs(res,vis,adj,i);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
        ArrayList<Integer> res=new ArrayList<>();
        dfs(res,vis,adj,0);
        return res;
    }
}
