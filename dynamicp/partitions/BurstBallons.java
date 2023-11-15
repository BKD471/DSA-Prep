package dynamicp.partitions;
import java.util.Arrays;
public class BurstBallons {
    private static int solve(int[] cost,int i,int j,int[][] memo){
        if(i>j) return 0;

        if(memo[i][j]!=-1) return memo[i][j];
        int min_coins=Integer.MIN_VALUE;
        for(int indx=i;indx<=j;indx++){
            int coins=cost[i-1]*cost[indx]*cost[j+1]+solve(cost,i,indx-1,memo)+solve(cost, indx+1, j,memo);
            min_coins=Math.max(min_coins,coins);
        }
        return memo[i][j]=min_coins;
    }
    public static int burstBalloons(int []arr){
        // Write your code here.
        int n=arr.length;
        int[] cost=new int[n+2];
        for(int i=1;i<=n;i++) cost[i]=arr[i-1];
        cost[0]=1;cost[n+1]=1;
        int[][] memo=new int[n+2][n+2];
        for(int i=0;i<=n+1;i++) Arrays.fill(memo[i],-1);
        return solve(cost,1,n,memo);
    }
}
