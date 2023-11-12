package shortestpath;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair1{
    int x,y,distance;
    Pair1(int x,int y,int distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
}
public class ShortesDistInMaze {
        private static final int limit=(int)(Math.pow(10,8));
        public static int shortestPathBinaryMatrix(int[][] matrix, Point src, Point dest) {
            // Write your code here
            int m=matrix.length,n=matrix[0].length,x=src.x,y=src.y,x1=dest.x,y1=dest.y;
            if(x<0 || y<0 || x>=m || y>=n || x1<0 || y1<0 || x1>=m || y1>=n
                    || matrix[x][y]==0 || matrix[x1][y1]==0) return -1;
            if((x==x1) && (y==y1)) return 0;
            int[][] dist=new int[m][n];
            for(int i=0;i<m;i++) Arrays.fill(dist[i], limit);
            dist[x][y]=0;

            Queue<Pair1> q=new LinkedList<>();
            q.offer(new Pair1(x,y,0));


            int[] rows={-1,0,1,0};
            int[] cols={0,-1,0,1};


            while(!q.isEmpty()){
                Pair1 temp=q.poll();
                int row=temp.x;
                int col=temp.y;
                int distance=temp.distance;

                for(int i=0;i<4;i++){
                    int nr=row+rows[i];
                    int nc=col+cols[i];

                    if(nr>=0 && nc>=0 && nr<m && nc<n && matrix[nr][nc]==1){
                        if(1+distance<dist[nr][nc]){
                            dist[nr][nc]=1+distance;
                            q.offer(new Pair1(nr,nc,dist[nr][nc]));
                        }
                    }
                }

            }
            return dist[x1][y1]==limit?-1:dist[x1][y1];

        }
}


