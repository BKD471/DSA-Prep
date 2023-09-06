package dynamicp;
import java.util.Arrays;

public class SubsetSum {
    private static long solve(int[] nums,int sum,int index,long[][] dp){
        if(sum<0) return 0;
        if(sum==0) return 1;
        if(index==nums.length) return 0;


        if(dp[index][sum]!=-1) return dp[index][sum];
        long take=solve(nums,sum-nums[index],index+1,dp);
        long non_take=solve(nums,sum,index+1,dp);
        if(take==1 || non_take==1) dp[index][sum]=1;
        else dp[index][sum]=0;
        return dp[index][sum];
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        long[][] dp=new long[arr.length+1][sum+1];
        for(int i=0;i<=arr.length;i++) Arrays.fill(dp[i],-1);
        return solve(arr,sum,0,dp)==1? true:false;
    }
}
