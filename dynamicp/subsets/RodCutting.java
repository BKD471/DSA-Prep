package dynamicp.subsets;
import java.util.Arrays;
public class RodCutting {
    private static int solve(int[] nums,int index,int len,int[][] memo){
        if(index>=nums.length) return 0;
        if(len<=0) return 0;
        if(memo[index][len]!=-1) return memo[index][len];
        int take=0;
        if(len>=index) take=nums[index-1]+solve(nums,index,len-index,memo);
        int not_take=solve(nums,index+1,len,memo);
        memo[index][len]=Math.max(take,not_take);
        return memo[index][len];
    }
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int[][] memo=new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i], -1);
        return solve(price, 1, n,memo);
    }
}
