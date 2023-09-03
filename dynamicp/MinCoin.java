package dynamicp;
import java.util.Arrays;
public class MinCoin {
    private static final int LIMIT=(int)(Math.pow(10,9));
    private int solve(int[] nums,int index,int target,int[][] dp){
        if(target<0) return LIMIT;
        if(index==0){
            if(target%nums[0]==0) return target/nums[index];
            return LIMIT;
        }
        if(dp[index][target]!=-1) return dp[index][target];

        int take=1+solve(nums,index,target-nums[index],dp);
        int non_take=solve(nums,index-1,target,dp);
        dp[index][target]=Math.min(take,non_take);

        return Math.min(take,non_take);
    }


    public int minCoins(int nums[], int n, int k)
    {
        // Your code goes here
        // code here.
        Arrays.sort(nums);
        int[][] dp=new int[nums.length+1][k+1];
        for(int i=0;i<=nums.length;i++) Arrays.fill(dp[i],-1);
        int res= solve(nums,nums.length-1,k,dp);
        return res==LIMIT? -1:res;
    }
}
