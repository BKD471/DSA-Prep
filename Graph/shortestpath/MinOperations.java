package shortestpath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Pair47{
    int node,distance;
    Pair47(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
}

public class MinOperations {
        private static final int limit=(int)(Math.pow(10,3));
        public static int minimumOperations(int n, int start, int end, int []a) {
            // Write your code here

            int[] dist=new int[limit];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start]=0;
            Queue<Pair47> q=new LinkedList<>();
            q.offer(new Pair47(start, 0));


            while(!q.isEmpty()){
                Pair47 temp=q.poll();
                int node=temp.node;
                int distance=temp.distance;

                for(int t:a){
                    int v=((t%limit)*(node%limit))%limit;
                    if(distance+1<dist[v]){
                        dist[v]=1+distance;
                        q.offer(new Pair47(v,dist[v]));
                    }
                }
            }
            return dist[end]==Integer.MAX_VALUE?-1:dist[end];
        }

}
