
import java.util.ArrayList;
import java.util.Arrays;
public class FloydWarsahll {
        private static final int LIMIT=(int)(Math.pow(10,9));
        static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {

            int[][] cost=new int[n][n];
            for(int i=0;i<n;i++) Arrays.fill(cost[i], LIMIT);

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j) cost[i][j]=0;
                }
            }
            for(ArrayList<Integer> temp:edges){
                int u=temp.get(0);
                int v=temp.get(1);
                int w=temp.get(2);
                cost[u-1][v-1]=w;
            }

            boolean negativeCycle=false;
            for(int via=0;via<n;via++){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(cost[i][i]<0) {
                            negativeCycle=true;
                            break;
                        }
                        if(cost[i][via]!=LIMIT && cost[via][j]!=LIMIT) cost[i][j]=Math.min(cost[i][j],cost[i][via]+cost[via][j]);
                    }
                }
            }

            if(negativeCycle) return -1;
            return cost[src-1][dest-1];
        }
    }

