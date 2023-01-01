
class Solution30 {
    public static int lookUp(boolean[][] visited,int row,int col,int m,int n){

        if(row==m-1 && col==n-1){
            return 1;
        }

        visited[row][col]=true;
        //Right

        int r=0,d=0;
        if(col<n-1 && !visited[row][col+1]){
            r=lookUp(visited,row,col+1,m,n);
            visited[row][col+1]=false;
        }

        //Down
        if(row<m-1 && !visited[row+1][col]){
            d=lookUp(visited,row+1,col,m,n);
            visited[row+1][col]=false;
        }

        return r+d;
    }

    public static int uniquePaths(int m, int n) {
        boolean[][] visited=new boolean[m][n];
        return lookUp(visited,0,0,m,n);

    }
}



public class UniquePathsBrute {
    public static void main(String[] args) {
        int paths=Solution30.uniquePaths(23,12);
        System.out.println(paths);
    }
}
