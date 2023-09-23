import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgo {
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Write your code here!
        int m=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] inDegree=new int[v];
        for(int i=0;i<=v;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
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
            int temp=q.poll();
            for(int i:adj.get(temp)){
                inDegree[i]--;
                if(inDegree[i]==0) q.offer(i);
            }
            res.add(temp);
        }
        return res;
    }
}
