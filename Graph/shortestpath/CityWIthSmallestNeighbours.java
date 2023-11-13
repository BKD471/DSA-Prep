package shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class CityWIthSmallestNeighbours {
    private static final int limit=(int)(Math.pow(10,8));
    public static int findTheCity(int n,
                                  ArrayList<ArrayList<Integer>> edges, int k) {
        // Write your code here

        int[][] cost=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(cost[i],limit);

        for(List<Integer> temp:edges){
            int u=temp.get(0);
            int v=temp.get(1);
            int w=temp.get(2);
            cost[u][v]=w;
            cost[v][u]=w;
        }

        for(int i=0;i<n;i++) cost[i][i]=0;

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) if(cost[i][via]!=limit && cost[via][j]!=limit) cost[i][j]=Math.min(cost[i][j],cost[i][via]+cost[via][j]);
            }
        }

        int mxCity=Integer.MAX_VALUE;
        int res=-1;
        for(int city=0;city<n;city++){
            int cnt=0;
            for(int adjCity=0;adjCity<n;adjCity++){
                if(cost[city][adjCity]<=k) cnt++;
            }

            if(cnt<=mxCity){
                mxCity=cnt;
                res=city;
            }
        }
        return res;
    }
}
