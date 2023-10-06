
import java.util.Arrays;
public class CityWithSmallestNeighborsInThreshold {
    private static final int LIMIT=(int)(Math.pow(10,9));
    public int findTheCity(int n, int[][] edges, int k) {
        int[][] cost=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(cost[i], LIMIT);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) cost[i][j]=0;
            }
        }
        for(int[] temp:edges){
            int u=temp[0];
            int v=temp[1];
            int w=temp[2];
            cost[u][v]=w;
            cost[v][u]=w;
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    if(cost[i][via]!=LIMIT && cost[via][j]!=LIMIT) cost[i][j]=Math.min(cost[i][j],cost[i][via]+cost[via][j]);
                }
            }
        }

        int mn=-1;
        int cntMn=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(cost[i][j]<=k) cnt++;
            }
            if(cntMn>=cnt){
                cntMn=cnt;
                mn=i;
            }
        }
        return mn;
    }
}
