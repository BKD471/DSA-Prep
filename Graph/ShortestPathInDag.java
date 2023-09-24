import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class PairDag{
    int val,weight;
    PairDag(int val,int weight){
        this.val=val;
        this.weight=weight;
    }
}

public class ShortestPathInDag {
    private static final int LIMIT=(int)(Math.pow(10,8));
    private static List<Integer> kahn(ArrayList<ArrayList<PairDag>> adj,int v){

        int[] inDeg=new int[v];
        for(int i=0;i<v;i++){
            for(PairDag j:adj.get(i)){
                int value=j.val;
                inDeg[value]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDeg[i]==0) q.offer(i);
        }

        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int t=q.poll();
            for(PairDag i:adj.get(t)){
                int value=i.val;
                inDeg[value]--;
                if(inDeg[value]==0) q.offer(value);
            }
            res.add(t);
        }
        return res;
    }
    public static int[] shortestPathInDAG(int v, int m, int [][]edges) {
        // Write your code here
        ArrayList<ArrayList<PairDag>> adj=new ArrayList<>();
        for(int i=0;i<=v;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u1=edges[i][0];
            int v1=edges[i][1];
            int w1=edges[i][2];
            adj.get(u1).add(new PairDag(v1,w1));
        }

        List<Integer> safeNodes=kahn(adj,v);
        int[] dist=new int[v];
        Arrays.fill(dist,LIMIT);

        dist[0]=0;
        while(!safeNodes.isEmpty()){
            int t=safeNodes.remove(0);
            for(PairDag i:adj.get(t)){
                int value=i.val;
                int weight=i.weight;
                if(dist[t]+weight<dist[value]){
                    dist[value]=dist[t]+weight;
                }
            }
        }
        for(int i=0;i<v;i++){
            if(dist[i]==LIMIT) dist[i]=-1;
        }
        return dist;
    }
}
