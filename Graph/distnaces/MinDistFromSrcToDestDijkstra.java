package distnaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

public class MinDistFromSrcToDestDijkstra {

    class Pair{
        int node,distance;
        Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }


    public class Solution {
        private static final int limit=(int)(Math.pow(10,8));
        public int solve(int n, ArrayList<ArrayList<Integer>> grid, int src, int dest) {
            ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
            for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

            for(int i=0;i<grid.size();i++){
                int u=grid.get(i).get(0);
                int v=grid.get(i).get(1);
                int w=grid.get(i).get(2);
                adj.get(u).add(new Pair(v,w));
                adj.get(v).add(new Pair(u,w));
            }

            Comparator<Pair> c=(a, b)-> a.distance<b.distance?-1:a.distance>b.distance?1:0;
            PriorityQueue<Pair> pq=new PriorityQueue<>(c);

            pq.offer(new Pair(src,0));
            int[] dist=new int[n];
            Arrays.fill(dist,limit);
            dist[src]=0;

            while(!pq.isEmpty()){
                Pair temp=pq.poll();

                int node=temp.node;
                int distance1=temp.distance;
                for(Pair t:adj.get(node)){
                    int tnode=t.node;
                    int distance2=t.distance;
                    if(distance2+distance1<dist[tnode]){
                        pq.offer(new Pair(tnode,distance2+distance1));
                        dist[tnode]=distance2+distance1;
                    }
                }
            }
            return dist[dest]==limit?-1:dist[dest];

        }
    }

}
