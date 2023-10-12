
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Tarjan {
    private int timer=1;
    public void dfs(int node,int parent,boolean[] vis,List<List<Integer>> adj,int[] tin,int[] tl,List<List<Integer>> res){
        vis[node]=true;
        tin[node]=tl[node]=timer;
        ++timer;
        for(int t:adj.get(node)){
            if(t==parent) continue;
            if(!vis[t]){
                dfs(t,node,vis,adj,tin,tl,res);
                tl[node]=Math.min(tl[t],tl[node]);

                if(tl[t]>tin[node]) res.add(Arrays.asList(t,node));
            }else tl[node]=Math.min(tl[node],tl[t]);
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(List<Integer> tmp:connections){
            int u=tmp.get(0);
            int v=tmp.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis=new boolean[n];
        int[] tin=new int[n];
        int[] tl=new int[n];

        List<List<Integer>> res=new ArrayList<>();
        dfs(0,-1,vis,adj,tin,tl,res);
        return res;
    }
}
