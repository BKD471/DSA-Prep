package dynamicp;
import java.util.Arrays;
public class PartitionInTwoSets {
    private static int solve(int[] nums,int index,int target,int[][] memo){
        if(target==0) return 1;
        if(target<0) return 0;
        if(index>=nums.length) return 0;

        if(memo[index][target]!=-1) return memo[index][target];
        int take=solve(nums, index+1, target-nums[index], memo);
        int non_take=solve(nums, index+1, target, memo);
        if(take==1 || non_take==1) memo[index][target]=1;
        else memo[index][target]=0;
        return memo[index][target];
    }
    public static boolean canPartition(int[] nums, int n) {
        // Write your code here.
        n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];
        if( (sum&1)==1) return false;
        int[][] memo=new int[n+1][sum+1];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return solve(nums,0,sum/2,memo)==1? true:false;
    }
}
