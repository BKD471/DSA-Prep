package dynamicp;
import java.util.Arrays;
public class ZeroOneKnapSack {
    private static int solve(int[] values,int[] weights,int target,int index,int[][] memo){
        if(index>=values.length) return 0;

        if(memo[target][index]!=-1) return memo[target][index];
        int take=Integer.MIN_VALUE;
        if(target>=weights[index]) take=values[index]+solve(values,weights,target-weights[index],index+1,memo);
        int non_take=solve(values,weights,target,index+1,memo);
        memo[target][index]=Math.max(take,non_take);
        return memo[target][index];
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        int[][] memo=new int[W+1][n+1];
        for(int i=0;i<=W;i++) Arrays.fill(memo[i],-1);
        return solve(val,wt,W,0,memo);
    }
}
