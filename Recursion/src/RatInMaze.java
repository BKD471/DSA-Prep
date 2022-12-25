import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helper.CodeHelper.displayList;

class Solution12 {
    public static ArrayList<String> findPath(int[][] path, int n) {
        boolean visited[][]=new boolean[n][n];
        for(boolean[] temp:visited){
            Arrays.fill(temp,false);
        }
        ArrayList<String> res=new ArrayList<>();
        solve(visited,path,n,res,0,0,"");
        return res.size() > 0 ? res : new ArrayList<>(List.of("-1"));
    }

    public static void solve(boolean[][] visited,int[][] path,int n,ArrayList<String> res,int row,int col,String s){
        if(row==n-1 && col==n-1 && path[row][col]==1){
            res.add(s);
            return;
        }
        if(path[row][col]==0) return;

        //Down
        if(row<n-1 && !visited[row+1][col] && path[row+1][col]==1){
            visited[row][col]=true;
            solve(visited,path,n,res,row+1,col,s+"D");
            visited[row][col]=false;
        }
        //Left
        if(col>0 && !visited[row][col-1] && path[row][col-1]==1){
            visited[row][col]=true;
            solve(visited,path,n,res,row,col-1,s+"L");
            visited[row][col]=false;
        }
        //Right
        if(col<n-1 && !visited[row][col+1] && path[row][col+1]==1){
            visited[row][col]=true;
            solve(visited,path,n,res,row,col+1,s+"R");
            visited[row][col]=false;
        }
        //Upper
        if(row>0 && visited[row-1][col]==false && path[row-1][col]==1){
            visited[row][col]=true;
            solve(visited,path,n,res,row-1,col,s+"U");
            visited[row][col]=false;
        }
    }
}

public class RatInMaze {
    public static void main(String[] args) {
        int[][] paths={
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        List<?> res=Solution12.findPath(paths,4);
        displayList(res);
    }
}
