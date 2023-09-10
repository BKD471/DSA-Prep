package dynamicp;

import java.util.Arrays;

public class NinjaRider {
    private static int solve(int[][] grid,int flag,int index,int[][] memo){
        if(index>=grid.length) return 0;
        int mxVal=Integer.MIN_VALUE;

        if(memo[flag][index]!=-1) return memo[flag][index];
        for(int j=0;j<3;j++){
            int val=Integer.MIN_VALUE;
            if(j!=flag) val=grid[index][j]+solve(grid,j,index+1,memo);
            mxVal=Math.max(mxVal,val);
        }

        memo[flag][index]=mxVal;
        return mxVal;
    }
    public static void main(String[] args) {
        int[][] grid={{1,2,5},{3,1,1},{3,3,3}};
        int[][] memo=new int[3][grid.length+1];
        for(int i=0;i<3;i++) Arrays.fill(memo[i],-1);
        System.out.println(solve(grid,0,0,memo));
    }
}

