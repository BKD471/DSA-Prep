package TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortUsingKahn {
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=v;i++) adj.add(new ArrayList<>());
        int[] inDegree=new int[v];
        for(int i=0;i<edges.length;i++){
            int u1=edges[i][0];
            int v1=edges[i][1];
            adj.get(u1).add(v1);
            inDegree[v1]++;
        }


        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i]==0) q.offer(i);
        }

        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            for(int t:adj.get(node)){
                inDegree[t]--;
                if(inDegree[t]==0) q.offer(t);
            }
            res.add(node);
        }
        return res;
    }
}
