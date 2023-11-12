package shortestpath;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Pair{
    int node,dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
public class IsReachable {
    private static final int limit=(int)(Math.pow(10,8));
        public int solve(int n, ArrayList<ArrayList<Integer>> grid) {
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
            for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

            for(int i=0;i<grid.size();i++){
                int u=grid.get(i).get(0);
                int v=grid.get(i).get(1);
                adj.get(u-1).add(v-1);
            }

            int[] dist=new int[n];
            Arrays.fill(dist,limit);
            dist[0]=0;
            Queue<Pair> q=new LinkedList<>();
            q.offer(new Pair(0,0));
            while(!q.isEmpty()){
                Pair temp=q.poll();
                int node=temp.node;

                for(int t:adj.get(node)){
                    if(dist[node]+1<dist[t]){
                        dist[t]=dist[node]+1;
                        q.offer(new Pair(t,dist[t]));
                    }
                }
            }
            return dist[n-1]==limit?0:1;
        }
}
