package dynamicp;
import java.util.Arrays;
public class UnboundedKnapSack {
    private static int solve(int[] values,int[] weights,int target,int index,int[][] memo){

        if(index>=values.length) return 0;

        if(memo[target][index]!=-1) return memo[target][index];
        int take=Integer.MIN_VALUE;
        if(target>=weights[index]) take=values[index]+solve(values,weights,target-weights[index],index,memo);

        int not_take=solve(values,weights,target,index+1,memo);
        memo[target][index]=Math.max(take,not_take);
        return memo[target][index];
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] memo=new int[W+1][N+1];
        for(int i=0;i<=W;i++) Arrays.fill(memo[i],-1);
        return solve(val,wt,W,0,memo);
    }
}
