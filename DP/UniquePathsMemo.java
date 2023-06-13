package DP;

import java.util.Arrays;



public class UniquePathsMemo {
    public static long lookUp(int row,int col,long[][] memo,int m,int n){
        if(memo[row][col]!=-1) return memo[row][col];

        if(row==m-1 && col==n-1) return 1;

        long r=0,d=0;
        //Right
        if(col<n-1){
            r=lookUp(row,col+1,memo,m,n);
        }

        //Down
        if(row<m-1 ){
            d=lookUp(row+1,col,memo,m,n);
        }

        memo[row][col]=r+d;
        return r+d;

    }
    public static long uniquePaths(int m, int n) {
        long[][] memo=new long[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return lookUp(0,0,memo,m,n);
    }
    public static void main(String[] args) {
        int m=20,n=27;
        System.out.println(uniquePaths(m,n));
    }
}
