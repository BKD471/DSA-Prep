package cycles;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;



public class CycleInUndirectedBfs {
    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj,
                                   boolean[] vis,int index){
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(index, -1));
        vis[index]=true;

        while(!q.isEmpty()){
            Pair temp=q.poll();

            int node=temp.node;
            int parent=temp.parent;

            for(int t:adj.get(node)){
                if(!vis[t]){
                    q.offer(new Pair(t, node));
                    vis[t]=true;
                }
                else if(parent!=t) return true;
            }
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
            if(!vis[i] && isCycle(adj, vis, i)) return "Yes";
        }
        return "No";

    }
}
