
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.Queue;

class PairDij{
    int v,w;
    PairDij(int v,int w){
        this.v=v;
        this.w=w;
    }
}


public class DijkstraMyWay {
    private static final int LIMIT=(int)(Math.pow(10,8));
    public static List<Integer> dijkstra(int[][] edge,int vertices,
                                         int edges,int source){
        int m=edge.length;
        List<List<PairDij>> adj=new ArrayList<>();
        for(int i=0;i<vertices;i++) adj.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            int w=edge[i][2];
            adj.get(u).add(new PairDij(v,w));
            adj.get(v).add(new PairDij(u,w));
        }

        int[] dist=new int[vertices];
        Arrays.fill(dist,LIMIT);

        dist[source]=0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(source);

        while(!q.isEmpty()){
            int t=q.poll();

            for(PairDij pd:adj.get(t)){
                int v=pd.v;
                int w=pd.w;

                if(dist[t]+w<dist[v]){
                    dist[v]=dist[t]+w;
                    q.offer(v);
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i:dist) res.add(i);
        return res;
    }
}
