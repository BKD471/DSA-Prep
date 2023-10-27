package dynamicp;

import java.util.Arrays;

public class NinjaRider {
    private static final int limit=(int)(-Math.pow(10,6)+7);
    private static int ninja(int[][] points,int row,int prev_index,int n,int[][] memo){
        if(row>=n) return 0;

        if(memo[row][prev_index+1]!=-1) return memo[row][prev_index+1];
        int max_take=limit;
        for(int i=0;i<3;i++){
            int take=limit;
            if(prev_index==-1 || prev_index!=i) take=points[row][i]+ninja(points, row+1, i, n,memo);
            max_take=Math.max(max_take,take);
        }
        memo[row][prev_index+1]=max_take;
        return max_take;
    }
    public static int ninjaTraining(int n, int points[][]) {
        int[][] memo=new int[n+1][4];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i], -1);
        return ninja(points, 0, -1, n,memo);
    }
}

