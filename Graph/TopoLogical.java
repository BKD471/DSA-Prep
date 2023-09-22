import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class TopoLogical {
    private static void dfs(ArrayList<ArrayList<Integer>> adj,
                            int[] vis,Stack<Integer> st,int index){

        vis[index]=1;
        for(int t:adj.get(index)){
            if(vis[t]==0) dfs(adj,vis,st,t);
        }
        st.push(index);
    }
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Write your code here!
        int m=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=v;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u1=edges[i][0];
            int v1=edges[i][1];
            adj.get(u1).add(v1);
        }

        int[] vis=new int[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(vis[i]==0) dfs(adj,vis,st,i);
        }
        List<Integer> res=new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.peek());
            st.pop();
        }
        return res;
    }
}
