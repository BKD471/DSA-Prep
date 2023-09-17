import java.util.LinkedList;
import java.util.Queue;


class Pairs{
    int row,col,time;
    Pairs(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;

        Queue<Pairs> q=new LinkedList<>();
        boolean[][] vis=new boolean[m][n];
        int orangeCount=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Pairs(i,j,0));
                    vis[i][j]=true;
                }
                if(grid[i][j]==1) orangeCount++;
            }
        }

        int tm=0;
        int[] row={-1,0,1,0};
        int[] col={0,-1,0,1};
        int cnt=0;
        while(!q.isEmpty()){
            Pairs temp=q.poll();
            int r=temp.row;
            int c=temp.col;
            int t=temp.time;

            tm=Math.max(tm,t);

            for(int i=0;i<4;i++){
                int irow=r+row[i];
                int icol=c+col[i];
                if(irow>=0 && icol>=0 && irow<m && icol<n && grid[irow][icol]==1 && !vis[irow][icol]){
                    cnt++;
                    vis[irow][icol]=true;
                    q.offer(new Pairs(irow,icol,t+1));
                }
            }
        }

        if(cnt!=orangeCount) return -1;
        return tm;
    }
}
