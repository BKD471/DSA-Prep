import java.util.List;
import java.util.ArrayList;
public class BellmanFord {
    private static final int LIMIT=(int)(Math.pow(10,8));
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        // Write your code here.
        int[] dist=new int[n+1];
        for(int i=1;i<=n;i++) dist[i]=LIMIT;
        dist[src]=0;
        boolean flag=false;
        for(int i=0;i<n-1;i++){
            for(List<Integer> temp:edges){
                int u=temp.get(0);
                int v=temp.get(1);
                int w=temp.get(2);
                if( dist[u]+w<dist[v]) dist[v]=dist[u]+w;
            }
        }

        for(List<Integer> temp:edges){
            int u=temp.get(0);
            int v=temp.get(1);
            int w=temp.get(2);
            if( dist[u]+w<dist[v]) {
                int[] t=new int[1];
                t[0]=-1;
                return t;
            }
        }
        return dist;
    }
}
