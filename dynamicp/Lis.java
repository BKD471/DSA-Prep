package dynamicp;
import java.util.Arrays;
public class Lis {
    private static int lis(int[] nums,int prev_index,int index,int[][] memo){
        if(index>=nums.length) return 0;
        if(memo[prev_index+1][index]!=-1) return memo[prev_index+1][index];
        int take=0;
        if(prev_index==-1 || nums[index]>nums[prev_index]) take=1+lis(nums,index,index+1,memo);
        int non_take=lis(nums,prev_index,index+1,memo);

        memo[prev_index+1][index]=Math.max(take,non_take);
        return memo[prev_index+1][index];
    }

    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int nums[])
    {
        // code here
        if(n==0) return 0;
        int[][] memo=new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return lis(nums,-1,0,memo);

    }
}
