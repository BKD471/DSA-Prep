import java.util.Arrays;

public class LisMemo {
    public int lis(int[] nums,int index,int prev_index,int[][] memo){
        if(index>=nums.length) return 0;

        if(memo[index][prev_index+1]!=-1) return memo[index][prev_index+1];

        int not_take=lis(nums,index+1,prev_index,memo);
        int take=0;
        if(prev_index==-1 || nums[index]>nums[prev_index]) take=1+lis(nums,index+1,index,memo);
        return memo[index][prev_index+1]=Math.max(not_take,take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] memo=new int[n][n+1];

        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
        return lis(nums,0,-1,memo);
    }
}
