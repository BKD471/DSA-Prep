import java.util.*;

class PairGp{
    int v,dist;
    PairGp(int v,int dist){
        this.v=v;
        this.dist=dist;
    }
}


public class ShortestPathInWeightedUndirectedGraph {
    private static final int LIMIT=(int)(Math.pow(10,7));
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here

        ArrayList<ArrayList<PairGp>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new PairGp(v,w));
            adj.get(v).add(new PairGp(u,w));
        }

        Comparator<PairGp> sortByDist=(x, y)-> x.dist<y.dist? -1: x.dist>y.dist?1:0;
        PriorityQueue<PairGp> pq=new PriorityQueue<>(sortByDist);
        pq.offer(new PairGp(1,0));

        int[] dist=new int[n+1];
        int[] parent=new int[n+1];
        Arrays.fill(dist,LIMIT);
        for(int i=1;i<=n;i++) parent[i]=i;
        dist[1]=0;

        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()){
            PairGp temp=pq.poll();

            int v1=temp.v;
            int dist1=temp.dist;

            for(PairGp i:adj.get(v1)){
                int v2=i.v;
                int dist2=i.dist;

                if(dist1+dist2<dist[v2]){
                    dist[v2]=dist1+dist2;
                    parent[v2]=v1;
                    pq.offer(new PairGp(v2,dist[v2]));
                }
            }
        }


        if(dist[n]==LIMIT) {
            List<Integer> t=new ArrayList<>();
            t.add(-1);
            return t;
        }


        int i=n;
        res.add(n);
        while(parent[i]!=i){
            res.add(parent[i]);
            i=parent[i];
        }

        Collections.reverse(res);
        return res;
    }
}
