package shortestpath;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Knight{
    int row,col,distance;
    Knight(int row,int col,int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
public class DarKnightRising {
    private static final int limit=(int)(Math.pow(10,8)+7);
    public int knight(int m, int n, int c, int d, int e, int f) {
        if(m<=0 || n<=0) return -1;
        c-=1;
        d-=1;
        e-=1;
        f-=1;
        if(c<0 || d<0 || c>=m || d>=n || e<0 || f<0 || e>=m || f>=n) return -1;
        if((c==e) && (d==f)) return 0;

        int[] rows={-2,-2,-1,-1,1,1,2,2};
        int[] cols={-1,1,-2,2,-2,2,-1,1};

        int[][] dist=new int[m][n];
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dist[i],limit);
        dist[c][d]=0;
        vis[c][d]=true;

        Queue<Knight> q=new LinkedList<>();
        q.offer(new Knight(c,d,0));

        while(!q.isEmpty()){
            Knight temp=q.poll();
            int rw=temp.row;
            int cl=temp.col;
            int distance=temp.distance;

            for(int i=0;i<8;i++){
                int nrow=rw+rows[i];
                int ncol=cl+cols[i];
                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && !vis[nrow][ncol] && distance+1<dist[nrow][ncol]){
                        dist[nrow][ncol]=distance+1;
                        q.offer(new Knight(nrow,ncol,dist[nrow][ncol]));
                }
            }
        }
        return dist[e][f]==limit? -1:dist[e][f];

    }
}
