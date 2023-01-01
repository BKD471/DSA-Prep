
class Solution33 {
    public static int lookUp(boolean[][] visited,int row,int col,int m,int n,int[][] hash){
        if(hash[row][col]!=0) return hash[row][col];
        if(row==m-1 && col==n-1){
            return 1;
        }

        visited[row][col]=true;

        //Right
        int r=0,d=0;
        if(col<n-1 && !visited[row][col+1]){
            r=lookUp(visited,row,col+1,m,n,hash);
            visited[row][col+1]=false;
        }

        //Down
        if(row<m-1 && !visited[row+1][col]){
            d=lookUp(visited,row+1,col,m,n,hash);
            visited[row+1][col]=false;
        }

        hash[row][col]=r+d;
        return r+d;
    }

    public static int uniquePaths(int m, int n) {
        boolean[][] visited=new boolean[m][n];
        int[][] hash=new int[m][n];
        return lookUp(visited,0,0,m,n,hash);

    }
}

public class UniquePathsDPOptimised {
    public static void main(String[] args) {
        int res=Solution33.uniquePaths(23,12);
        System.out.println(res);
    }
}
