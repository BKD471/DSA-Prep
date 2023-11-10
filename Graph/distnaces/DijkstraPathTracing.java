package distnaces;

import java.util.*;

public class DijkstraPathTracing {
    private static final int limit=(int)(Math.pow(10,8))+7;
    public static List<Integer> shortestPath(int n, int m, int edges[][]){

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u-1).add(new Pair(v-1,w));
            adj.get(v-1).add(new Pair(u-1,w));
        }

        int[] dist=new int[n];
        Arrays.fill(dist,limit);
        Comparator<Pair> c=(a, b)->a.dist<b.dist?-1:a.dist>b.dist?1:0;
        PriorityQueue<Pair> pq=new PriorityQueue<>(c);
        pq.offer(new Pair(0,0));
        dist[0]=0;
        int[] parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;

        while(!pq.isEmpty()){
            Pair temp=pq.poll();

            int node=temp.node;
            int distance=temp.dist;

            for(Pair t:adj.get(node)){
                int nodet=t.node;
                int distance1=t.dist;
                if(distance1+distance<dist[nodet]){
                    dist[nodet]=distance+distance1;
                    pq.offer(new Pair(nodet,dist[nodet]));
                    parent[nodet]=node;
                }
            }
        }
        if(dist[n-1]==limit) {
            List<Integer> t=new ArrayList<>();
            t.add(-1);
            return t;
        }

        List<Integer> res=new ArrayList<>();
        res.add(n);

        int i=n-1;
        while(i>0){
            res.add(parent[i]+1);
            i=parent[i];
        }

        Collections.reverse(res);
        return res;

    }

    public static void main(String[] args) {
        int V = 5, E = 6;
        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
        List<Integer> res=shortestPath(V,E,edges);
        System.out.println(res);
    }
}
