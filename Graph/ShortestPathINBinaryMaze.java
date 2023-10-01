import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class PairGr{
    int r,c,d;
    PairGr(int r,int c,int d){
        this.r=r;
        this.c=c;
        this.d=d;
    }
}


public class ShortestPathINBinaryMaze {
        private static final int LIMIT=(int)(Math.pow(10,7));
        public int shortestPathBinaryMatrix(int[][] grid) {
            int m=grid.length;
            if(m==0 || grid[0][0]==1 || grid[m-1][m-1]==1) return -1;
            int[][] dist=new int[m][m];
            for(int i=0;i<m;i++) Arrays.fill(dist[i],LIMIT);

            dist[0][0]=1;
            Queue<PairGr> q=new LinkedList<>();
            q.offer(new PairGr(0,0,1));

            int[] rows={0, -1, 0,1,-1,1, 1,-1};
            int[] cols={-1, 0 ,1,0, 1,1,-1,-1};
            while(!q.isEmpty()){
                PairGr temp=q.poll();

                int r=temp.r;
                int c=temp.c;
                int d=temp.d;

                for(int i=0;i<8;i++){
                    int nrow=r+rows[i];
                    int ncol=c+cols[i];
                    if(nrow>=0 && ncol>=0 && nrow<m && ncol<m &&
                            grid[nrow][ncol]==0 && 1+d<dist[nrow][ncol]){
                        dist[nrow][ncol]=1+d;
                        q.offer(new PairGr(nrow,ncol,1+d));
                    }
                }
            }
            if(dist[m-1][m-1]==LIMIT) return -1;
            return dist[m-1][m-1];
        }
    }
}
