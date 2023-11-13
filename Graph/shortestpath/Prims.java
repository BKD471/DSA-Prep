package shortestpath;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
class Pair691{
    int n,v,p;
    Pair691(int n,int v,int p){
        this.n=n;
        this.v=v;
        this.p=p;
    }
}

class Pair6911{
    int n,v;
    Pair6911(int n,int v){
        this.n=n;
        this.v=v;
    }
}
public class Prims {
    private static final int limit=(int)(Math.pow(10,9)+7);
    public int solve(int n, int[][] grid) {
        int m=grid.length;

        ArrayList<ArrayList<Pair6911>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        boolean[] vis=new boolean[n];
        for(int i=0;i<m;i++){
            int u=grid[i][0];
            int v=grid[i][1];
            int w=grid[i][2];

            adj.get(u-1).add(new Pair6911(v-1,w));
            adj.get(v-1).add(new Pair6911(u-1,w));
        }

        Comparator<Pair691> c=(a,b)->a.v<b.v?-1:a.v>b.v?1:0;
        PriorityQueue<Pair691> pq=new PriorityQueue<>(c);

        pq.offer(new Pair691(0,0,-1));
        int sum=0;
        while(!pq.isEmpty()){
            Pair691 temp=pq.poll();
            int node=temp.n;
            int value=temp.v;

            if(!vis[node]){
                vis[node]=true;
                sum=(sum%limit+value%limit)%limit;
                for(Pair6911 t:adj.get(node)){
                    int nodet=t.n;
                    int valuet=t.v;
                    if(!vis[nodet]) pq.offer(new Pair691(nodet,valuet,node));
                }
            }
        }
        return sum;
    }
}
