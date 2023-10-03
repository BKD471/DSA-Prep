
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

class Pair47{
    int v;
    long d;
    Pair47(int v,long d){
        this.v=v;
        this.d=d;
    }
}

class Pair471{
    long distance;
    int node;
    Pair471(long distance,int node){
        this.distance=distance;
        this.node=node;
    }
}

public class NumberOfWaysToArriveAtDest {
    private static final int LIMIT=(int)(Math.pow(10,9)+7);
    public int countPaths(int n, int[][] grid) {
        int m=grid.length;

        ArrayList<ArrayList<Pair47>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int u=grid[i][0];
            int v=grid[i][1];
            int w=grid[i][2];
            adj.get(u).add(new Pair47(v,(long) w));
            adj.get(v).add(new Pair47(u,(long) w));
        }

        int[] ways=new int[n];
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE/2);
        Arrays.fill(ways,0);
        dist[0]=0;
        ways[0]=1;

        Comparator<Pair471> c=(x,y)-> x.distance<y.distance? -1:x.distance>y.distance?1:0;
        PriorityQueue<Pair471> pq=new PriorityQueue<>(c);
        pq.offer(new Pair471(0,0));

        while(!pq.isEmpty()){
            Pair471 temp=pq.poll();
            long distance1=temp.distance;
            int node=temp.node;

            for(Pair47 t:adj.get(node)){
                long distance2=t.d;
                int node2=t.v;
                if(distance1+distance2<dist[node2]){
                    dist[node2]=(distance1+distance2);
                    ways[node2]=ways[node];
                    pq.offer(new Pair471(dist[node2],node2));
                }
                else if(distance1+distance2==dist[node2]){
                    ways[node2]=(ways[node2]+ways[node])%LIMIT;
                }
            }
        }


        return ways[n-1]%LIMIT;
    }
}
