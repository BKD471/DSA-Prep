import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class BellmanFord {
    private static final int LIMIT=(int)(Math.pow(10,8));
    public static int[] bellmonFord(int v, int m, int src, List<List<Integer>> edges) {
        // Write your code here.
        int[] dist=new int[v];
        Arrays.fill(dist,LIMIT);
        dist[src]=0;

        boolean f=false;
        for(int i=0;i<v;i++){
            for(List<Integer> temp:edges){
                int u1=temp.get(0);
                int v1=temp.get(1);
                int w1=temp.get(2);
                if(dist[u1]!=LIMIT && dist[u1]+w1<dist[v1]){
                    if(i==v-1){
                        f=true;
                        break;
                    }
                    dist[v1]=dist[u1]+w1;
                }
            }
        }

        if(f) return new int[]{-1};
        return dist;
    }
}
