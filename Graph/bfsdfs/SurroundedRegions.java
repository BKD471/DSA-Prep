package bfsdfs;

import java.util.ArrayList;

public class SurroundedRegions {
    private void lookup(ArrayList<ArrayList<Character>> grid, int[][] vis, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid.get(i).get(j)=='X' || vis[i][j]==1) return;
        vis[i][j]=1;

        //up
        lookup(grid,vis,i-1,j,m,n);
        //down
        lookup(grid,vis,i+1,j,m,n);
        //right
        lookup(grid,vis,i,j+1,m,n);
        //left
        lookup(grid,vis,i,j-1,m,n);
    }
    public void solve(ArrayList<ArrayList<Character>> grid) {
        int m=grid.size(),n=grid.get(0).size();

        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            if(grid.get(i).get(0)=='O')  lookup(grid,vis,i,0,m,n);
            if(grid.get(i).get(n-1)=='O') lookup(grid,vis,i,n-1,m,n);
        }
        for(int i=0;i<n;i++){
            if(grid.get(0).get(i)=='O')  lookup(grid,vis,0,i,m,n);
            if(grid.get(m-1).get(i)=='O') lookup(grid,vis,m-1,i,m,n);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)=='O' && vis[i][j]!=1) grid.get(i).set(j,'X');
            }
        }
    }
}
