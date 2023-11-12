package shortestpath;

import java.util.*;


class PairWays{
    int node,distance;
    PairWays(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
}
public class Ways {
    private static final int limit=(int)(Math.pow(10,9)+7);
    public static int numberOfWays(int n, int m, int [][] edges) {
        // Write your code here
        ArrayList<ArrayList<PairWays>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new PairWays(v,w));
            adj.get(v).add(new PairWays(u,w));
        }

        int[] dist=new int[n];
        int[] ways=new int[n];
        Arrays.fill(dist,limit);
        dist[0]=0;
        ways[0]=1;

        Comparator<PairWays> c=(a, b)->a.distance<b.distance?-1:a.distance>b.distance?1:0;
        PriorityQueue<PairWays> pq=new PriorityQueue<>(c);

        pq.offer(new PairWays(0,0));
        while(!pq.isEmpty()){
            PairWays temp=pq.poll();

            int node=temp.node;
            int distance=temp.distance;

            for(PairWays t:adj.get(node)){
                int nodet=t.node;
                int distance1=t.distance;
                if(distance+distance1<dist[nodet]){
                    dist[nodet]=(distance+distance1);
                    ways[nodet]=ways[node];
                    pq.offer(new PairWays(nodet,dist[nodet]));
                }else if(distance+distance1==dist[nodet]){
                    ways[nodet]=(ways[nodet]%limit+ways[node]%limit)%limit;
                }
            }
        }
        return ways[n-1]==limit? -1:ways[n-1]%limit;
    }
}
