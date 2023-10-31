package cycles;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class CycleInDirectedGraphKahnBfs {
    public static boolean detectCycleInDirectedGraph(
            int n, ArrayList <ArrayList< Integer >> edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        int[] inDegree=new int[n];
        for(int i=0;i<edges.size();i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            adj.get(u-1).add(v-1);
            inDegree[v-1]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
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
        return res.size() != n;
    }
}
