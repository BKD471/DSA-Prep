import java.util.*;

class PairDijs{
    int v,dist;
    PairDijs(int v,int dist){
        this.v=v;
        this.dist=dist;
    }
}

public class DijkstraOriginal {

        private static final int LIMIT=(int)(Math.pow(10,8));
        public static List<Integer> dijkstra(int[][] edge, int vertices,
                                             int edges, int source){
            int m=edge.length;
            List<List<PairDijs>> adj=new ArrayList<>();
            for(int i=0;i<vertices;i++) adj.add(new ArrayList<>());

            for(int i=0;i<m;i++){
                int u=edge[i][0];
                int v=edge[i][1];
                int w=edge[i][2];
                adj.get(u).add(new PairDijs(v,w));
                adj.get(v).add(new PairDijs(u,w));
            }

            int[] dist=new int[vertices];
            Arrays.fill(dist,LIMIT);
            dist[source]=0;

            Comparator<PairDijs> sortByDistance=
                    (x,y)-> x.dist<y.dist? -1: x.dist>y.dist?1:0;
            PriorityQueue<PairDijs> pq=new PriorityQueue<PairDijs>(sortByDistance);
            pq.offer(new PairDijs(source,0));

            while(!pq.isEmpty()){
                PairDijs temp=pq.poll();
                int v=temp.v;
                int distance=temp.dist;

                for(PairDijs i:adj.get(v)){
                    int v1=i.v;
                    int distance1=i.dist;
                    if(distance1+distance<dist[v1]){
                        dist[v1]=distance+distance1;
                        pq.offer(new PairDijs(v1, dist[v1]));
                    }
                }
            }
            List<Integer> distances=new ArrayList<>();
            for(int i:dist) distances.add(i);
            return distances;
        }
}
