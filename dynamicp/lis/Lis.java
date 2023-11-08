package dynamicp.lis;
import java.util.Arrays;
public class Lis {
    private static int solve(int[] nums,int index,int prev_index,int[][] memo){
        if(index>=nums.length) return 0;
        if(memo[index][prev_index+1]!=-1) return memo[index][prev_index+1];
        int take=0;
        if(prev_index==-1 || nums[index]>nums[prev_index]){
            take=1+solve(nums,index+1,index,memo);
        }
        int not_take=solve(nums,index+1,prev_index,memo);
        memo[index][prev_index+1]=Math.max(take,not_take);
        return memo[index][prev_index+1];
    }

    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int n=arr.length;
        int[][] memo=new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return solve(arr,0,-1,memo);
    }

 //tabulatio n
    public static int longestIncreasingSubsequenceTabulation(int arr[]) {
        //Your code goes here
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int not_take=dp[i+1][j+1];
                int take=0;
                if(j==-1 || arr[i]>arr[j]){
                    take=1+dp[i+1][i+1];
                }
                dp[i][j+1]=Math.max(take,not_take);
            }
        }
        return dp[0][0];
    }
}
