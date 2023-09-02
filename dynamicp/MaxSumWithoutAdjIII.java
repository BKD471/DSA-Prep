package dynamicp;
import java.util.Arrays;
public class MaxSumWithoutAdjIII {
    private int solve(int[][] nums,int index,int[] dp){

        if(index<0) return 0;
        if(index==0) return nums[0][0];
        if(dp[index]!=-1) return dp[index];


        int take=nums[0][index]+solve(nums,index-2,dp);
        int non_take=solve(nums,index-1,dp);
        dp[index]=Math.max(take,non_take);
        return dp[index];
    }
    public int adjacent(int[][] nums) {
        int n=nums.length;
        int m=nums[0].length;
        if(m==1) return Math.max(nums[0][0],nums[1][0]);
        int[] dp=new int[m+1];
        Arrays.fill(dp,-1);

        for(int i=0;i<m;i++) nums[0][i]=Math.max(nums[0][i],nums[1][i]);

        return solve(nums,m-1,dp);
    }
}
