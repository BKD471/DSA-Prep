package shortestpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pairss{
    int row,col,distance;
    Pairss(int row,int col,int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
public class NearestZeo {
    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat,
                                                        int m, int n) {
        // Write your code here.
        boolean[][] vis=new boolean[m][n];
        int[][] dist=new int[m][n];

        Queue<Pairss> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat.get(i).get(j)==1){
                    q.offer(new Pairss(i,j,0));
                    vis[i][j]=true;
                    dist[i][j]=0;
                }
            }
        }

        int[] rows={-1,0,1,0};
        int[] cols={0,-1,0,1};

        while(!q.isEmpty()){
            Pairss temp=q.poll();
            int distance=temp.distance;
            int r=temp.row;
            int c=temp.col;
            for(int i=0;i<4;i++){
                int nrow=r+rows[i];
                int ncol=c+cols[i];

                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && !vis[nrow][ncol]){
                    q.offer(new Pairss(nrow, ncol, distance+1));
                    vis[nrow][ncol]=true;
                    dist[nrow][ncol]=distance+1;
                }
            }
        }

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for(int i=0;i<m;i++) res.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res.get(i).add(dist[i][j]);
            }
        }
        return res;
    }
}
