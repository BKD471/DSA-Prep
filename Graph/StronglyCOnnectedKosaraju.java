

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class StronglyCOnnectedKosaraju {
    public void dfs1(ArrayList<ArrayList<Integer>> adj,boolean[] vis,
                     Stack<Integer> st,int index){
        vis[index]=true;
        for(int i:adj.get(index)){
            if(!vis[i]) dfs1(adj,vis,st,i);
        }
        st.push(index);
    }


    public void dfs2(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int index){
        vis[index]=true;
        for(int i:adj.get(index)){
            if(!vis[i]) dfs2(adj,vis,i);
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[] vis=new boolean[v];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<v;i++){
            if(!vis[i]) dfs1(adj,vis,st,i);
        }

        ArrayList<ArrayList<Integer>> reversedGraph=new ArrayList<>();
        for(int i=0;i<=v;i++) reversedGraph.add(new ArrayList<>());

        int m=adj.size();
        for(int i=0;i<m;i++){
            for(int j:adj.get(i)){
                reversedGraph.get(j).add(i);
            }
        }

        Arrays.fill(vis,false);

        int scc=0;
        while(!st.isEmpty()){
            int node=st.pop();
            if(!vis[node]) {
                scc++;
                dfs2(reversedGraph,vis,node);
            }
        }
        return scc;
    }
}
