package shortestpath;

import dynamicp.Lis;

import java.util.*;

class Pair69{
    int n,d;
    Pair69(int n,int d){
        this.n=n;
        this.d=d;
    }
}

class Pair691{
    int steps,node,distance;
    Pair691(int steps,int node,int distance){
        this.steps=steps;
        this.node=node;
        this.distance=distance;
    }
}
public class CheapestFlightsWithinKStops {
    private static final int limit=(int)(Math.pow(10,8));
    public static int savingMoney(int n, int src,
                                  int dest, int k, List<List<Integer>> grid) {
        // Write your code here.
        ArrayList<ArrayList<Pair69>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList());

        for(int i=0;i<grid.size();i++){
            int u=grid.get(i).get(0);
            int v=grid.get(i).get(1);
            int w=grid.get(i).get(2);
            adj.get(u).add(new Pair69(v,w));
        }

        int[] dist=new int[n];
        Arrays.fill(dist,limit);
        dist[src]=0;

        Queue<Pair691> q=new LinkedList<>();
        q.offer(new Pair691(0,src,0));

        while(!q.isEmpty()){
            Pair691 temp=q.poll();

            int node=temp.node;
            int steps=temp.steps;
            int distance=temp.distance;
            if(node==dest) continue;
            for(Pair69 t:adj.get(node)){
                int nodet=t.n;
                int distance1=t.d;

                if(distance+distance1<dist[nodet] && steps<=k){
                    dist[nodet]=distance+distance1;
                    q.offer(new Pair691(steps+1,nodet,dist[nodet]));
                }
            }
        }
        for(int i=0;i<n;i++) System.out.print(dist[i]+" ");
        return dist[dest]==limit? -1:dist[dest];
    }

    public static void main(String[] args) {
        List<Integer> t1=Arrays.asList(0,1,5);
        List<Integer> t2=Arrays.asList(0,3,2);
        List<Integer> t4=Arrays.asList(3,1,2);
        List<Integer> t5=Arrays.asList(1,2,5);
        List<Integer> t6=Arrays.asList(1,4,1);
        List<Integer> t7=Arrays.asList(4,2,1);
        List<List<Integer>> grid=new ArrayList<>();
        grid.add(t1);
        grid.add(t2);
        grid.add(t4);grid.add(t5);grid.add(t6);grid.add(t7);
       savingMoney(5,0,2,2,grid);
    }
}
