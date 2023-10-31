package dynamicp.subsets;

public class PartitionIntoEqualSubset {
    private static Boolean solve(int[] nums, int index, int v, Boolean[][] memo) {
        if(v==0) return true;
        if (index == nums.length - 1) {
            if (v==nums[index]) return true;
            else return false;
        }

        if(memo[index][v]!=null) return memo[index][v];
        Boolean take=false;
        if(v>=nums[index]) take=solve(nums, index+1, v-nums[index], memo);
        Boolean not_take=solve(nums, index+1, v, memo);
        memo[index][v]=take || not_take;
        return memo[index][v];
    }
    public static boolean canPartition(int[] arr, int n) {
        // Write your code here.
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if((sum&1)!=0) return false;
        Boolean[][] memo = new Boolean[n + 1][(int)(sum/2) + 1];
        return solve(arr, 0, (int)sum/2, memo);

    }
}
