import java.util.LinkedList;
import java.util.Queue;

class PairsZm{
    int row,col,level;
    PairsZm(int row,int col,int level){
        this.row=row;
        this.col=col;
        this.level=level;
    }
}


public class ZeroOneMatrix {
        public int[][] updateMatrix(int[][] grid) {
            int m=grid.length,n=grid[0].length;
            boolean[][] vis=new boolean[m][n];
            Queue<PairsZm> q=new LinkedList<>();
            int[][] res=new int[m][n];

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==0){
                        q.offer(new PairsZm(i,j,0));
                        vis[i][j]=true;
                        res[i][j]=0;
                    }
                }
            }


            int[] rows={0,-1,1,0};
            int[] cols={-1,0,0,1};

            while(!q.isEmpty()){
                PairsZm temp=q.poll();
                int r=temp.row;
                int c=temp.col;
                int l=temp.level;

                res[r][c]=l;
                for(int i=0;i<4;i++){
                    int irow=r+rows[i];
                    int icol=c+cols[i];


                    if(irow>=0 && icol>=0 && irow<m && icol<n && grid[irow][icol]==1 && !vis[irow][icol]){
                        q.offer(new PairsZm(irow,icol,l+1));
                        vis[irow][icol]=true;
                    }
                }
            }
            return res;
        }
}
