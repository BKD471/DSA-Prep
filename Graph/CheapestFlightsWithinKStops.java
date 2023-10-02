
import java.util.*;



class PairGrph{
    int v,w;
    PairGrph(int v,int w){
        this.v=v;
        this.w=w;
    }
}

class Nodes{
    int dist,node,stops;
    Nodes(int stops,int node,int dist){
        this.stops=stops;
        this.dist=dist;
        this.node=node;
    }
}
public class CheapestFlightsWithinKStops {
    private static final int LIMIT=(int)(Math.pow(10,7));
    public int findCheapestPrice(int n, int[][] grid, int src, int dst, int k) {
        int m=grid.length;
        ArrayList<ArrayList<PairGrph>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int u=grid[i][0];
            int v=grid[i][1];
            int w=grid[i][2];
            adj.get(u).add(new PairGrph(v,w));
        }

        int[] dist=new int[n];
        Arrays.fill(dist,LIMIT);

        dist[src]=0;
        Queue<Nodes> q=new LinkedList<>();
        q.offer(new Nodes(0,src,0));

        while(!q.isEmpty()){
            Nodes temp=q.poll();
            int stops=temp.stops;
            int distance1=temp.dist;
            int node=temp.node;
            if(node==dst) continue;
            for(PairGrph t:adj.get(node)){
                int nd=t.v;
                int distance2=t.w;

                if(distance1+distance2<dist[nd] && stops<=k){
                    dist[nd]=distance1+distance2;
                    q.offer(new Nodes(stops+1,nd,dist[nd]));
                }
            }
        }
        if(dist[dst]==LIMIT) return -1;
        return dist[dst];
    }
}
