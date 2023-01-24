import java.util.LinkedList;
import java.util.Queue;

public class SnakeGame {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        boolean[][] vis=new boolean[n][n];
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(1);
        int steps=0;

        vis[n-1][0]=true;
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int v=q.poll();

                if(v==n*n) return steps;
                for(int j=1;j<=6;j++){
                    if(v+j>n*n) break;

                    int[] coord=findCoordinates(v+j,n);
                    int row=coord[0];
                    int col=coord[1];
                    if(vis[row][col]==true) continue;

                    vis[row][col]=true;
                    if(board[row][col]==-1)q.add(v+j);
                    else q.add(board[row][col]);
                }
            }
            steps++;
        }
        return -1;
    }

    public  int[] findCoordinates(int x,int n){
        int row=n-(x-1)/n-1;
        int col=(x-1)%n;
          //this is the only tricky part

        //if both row and length of matrix is either odd or even then return col= n-1-col
        // see the board to understand why is this
        if(n%2==row%2) return new int[]{row,n-1-col};
        else return new int[]{row,col};
    }
}
