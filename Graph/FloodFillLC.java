import java.util.Arrays;

public class FloodFillLC {
    public void solve(int[][] image,boolean[][] visited,int row,int col,int color,int m,int n,int keys){


        image[row][col]=color;
        visited[row][col]=true;
        //DOWN
        if(row<m-1 && !visited[row+1][col] && image[row+1][col]==keys){
            solve(image,visited,row+1,col,color,m,n,keys);
        }

        //UP
        if(row>0 && !visited[row-1][col]  && image[row-1][col]==keys){
            solve(image,visited,row-1,col,color,m,n,keys);
        }

        //Left
        if(col>0 && !visited[row][col-1] && image[row][col-1]==keys){
            solve(image,visited,row,col-1,color,m,n,keys);
        }

        //Right
        if(col<n-1 &&  !visited[row][col+1]  && image[row][col+1]==keys){
            solve(image,visited,row,col+1,color,m,n,keys);
        }


    }


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int key=image[sr][sc];
        boolean[][] visited=new boolean[m][n];
        for(boolean[] temp:visited){
            Arrays.fill(temp,false);
        }

        solve(image,visited,sr,sc,color,m,n,key);
        return image;
    }
}
