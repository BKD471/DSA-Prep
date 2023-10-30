package dynamicp.subsets;

public class SubsetSumEqualsK {
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
    public static boolean subsetSumToK(int n, int v, int nums[]){
        // Write your code here.
        Boolean[][] memo = new Boolean[n + 1][v + 1];
        return solve(nums, 0, v, memo);
    }
}
