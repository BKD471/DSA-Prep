package distnaces;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Ninja{
    int row,col,distance;
    Ninja(int row,int col,int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
public class PathWithMinEffort {
    private static final int limit=(int)(Math.pow(10,8));
    public static int minimumTimeTakingPath(int[][] matrix){
        // Write your code here.
        int m=matrix.length,n=matrix[0].length;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dist[i],limit);
        dist[0][0]=0;

        Comparator<Ninja> sortByDistance=(a,b)->a.distance<b.distance?-1:a.distance>b.distance?1:0;
        PriorityQueue<Ninja> pq=new PriorityQueue<>(sortByDistance);
        pq.offer(new Ninja(0,0,0));


        int[] rows={-1,0,1,0};
        int[] cols={0,-1,0,1};
        while(!pq.isEmpty()){
            Ninja temp=pq.poll();
            int row=temp.row;
            int col=temp.col;
            int effort=temp.distance;

            for(int i=0;i<4;i++){
                int nrow=row+rows[i];
                int ncol=col+cols[i];

                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n){
                    int newEffort=Math.abs(matrix[row][col]-matrix[nrow][ncol]);
                    if(newEffort<effort) newEffort=effort;

                    if(newEffort<dist[nrow][ncol]){
                        pq.offer(new Ninja(nrow, ncol,newEffort));
                        dist[nrow][ncol]=newEffort;
                    }
                }
            }

        }
        return dist[m-1][n-1]==limit?0:dist[m-1][n-1];
    }
}
