import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ShortestPathInUnDirectedGraph {
    private static final int LIMIT=(int)(Math.pow(10,8));
    public static int[] shortestPath(int n, int [][]grid, int src) {
        // Write your code here.
        int m=grid.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int u=grid[i][0],v=grid[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist=new int[n];
        Arrays.fill(dist,LIMIT);
        dist[src]=0;

        Queue<Integer> q=new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            int t=q.poll();
            for(int i:adj.get(t)){
                if(dist[t]+1<dist[i]){
                    dist[i]=dist[t]+1;
                    q.offer(i);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(dist[i]==LIMIT) dist[i]=-1;
        }
        return dist;
    }
}
