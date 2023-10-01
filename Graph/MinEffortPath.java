
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinEffortPath {
    private static final int LIMIT=(int)(Math.pow(10,7));
    public int minimumEffortPath(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dist[i],LIMIT);

        dist[0][0]=0;
        Comparator<PairGr> sortByDist=(x,y)-> x.d<y.d?-1:x.d>y.d?1:0;
        PriorityQueue<PairGr> q=new PriorityQueue<>(sortByDist);
        q.offer(new PairGr(0,0,0));



        int[] rows={0,-1,0,1};
        int[] cols={-1,0 ,1,0};

        while(!q.isEmpty()){
            PairGr temp=q.poll();
            int r=temp.r;
            int c=temp.c;
            int d=temp.d;


            for(int i=0;i<4;i++){
                int nrow=r+rows[i];
                int ncol=c+cols[i];

                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n){
                    int effort=Math.max(Math.abs(grid[r][c]-grid[nrow][ncol]),d);

                    if(effort<dist[nrow][ncol]){
                        dist[nrow][ncol]=effort;
                        q.offer(new PairGr(nrow,ncol,effort));
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}
