package dynamicp;
import java.util.Arrays;
public class TargetSum {
    private int solve(int[] nums,int index,int target,int[][] memo){
        if(index==nums.length-1){
            if(nums[index]==0 && target==0) return 2;
            if(nums[index]==target || target==0) return 1;
            return 0;
        }
        if(memo[index][target]!=-1) return memo[index][target];
        int take=0;
        if(target>=nums[index]) take=solve(nums,index+1,target-nums[index],memo);
        int not_take=solve(nums,index+1,target,memo);
        memo[index][target]=take+not_take;
        return memo[index][target];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;

        for(int i=0;i<n;i++) sum+=nums[i];

        if(sum-target<0) return 0;
        if(((sum-target)&1)==1) return 0;
        int t=(sum-target)/2;
        int[][] memo=new int[n+1][t+1];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return solve(nums,0,t,memo);
    }
}
