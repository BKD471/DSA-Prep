package dynamicp;
import java.util.Arrays;
public class NoOfSubsetsWithDiffK {
    private static final int LIMIT=(int)(Math.pow(10,9)+7);
    private static int solve(int[] nums,int index,int target,int[][] memo){
        if(target==0) return 1;
        if(index>=nums.length) return 0;

        if(memo[index][target]!=-1) return memo[index][target];
        int take=0;
        if(target>=nums[index]) take=solve(nums,index+1,target-nums[index],memo);
        int non_take=solve(nums,index+1,target,memo);
        memo[index][target]=(take%LIMIT+non_take%LIMIT)%LIMIT;
        return memo[index][target];
    }
    public static int countPartitions(int n, int d, int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        if(sum-d<0) return 0;
        if((sum-d)%2!=0) return 0;
        int target=(sum-d)/2;
        int[][] memo=new int[nums.length+1][target+1];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        Arrays.sort(nums);
        return solve(nums,0,target,memo);
    }
}
