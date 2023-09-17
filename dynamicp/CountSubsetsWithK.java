package dynamicp;

import java.util.Arrays;

public class CountSubsetsWithK {
    private static final int LIMIT=(int)(Math.pow(10,9)+7);
    private static int solve(int[] nums,int index,int target,int[][] memo){
        if(target==0) return 1;
        if(target<0) return 0;
        if(index>=nums.length) return  0;

        if(memo[index][target]!=-1) return memo[index][target];
        int take=0;
        if(target>=nums[index]) take=solve(nums,index+1,target-nums[index],memo);
        int non_take=solve(nums,index+1,target,memo);
        memo[index][target]=(take%LIMIT+non_take%LIMIT)%LIMIT;
        return memo[index][target];
    }
    public static void main(String[] args) {
        int[] nums={0,1,0};
        int k=1;
        int[][] memo=new int[nums.length+1][k+1];
        for(int i=0;i<=nums.length;i++) Arrays.fill(memo[i],-1);
        Arrays.sort(nums);
        System.out.println(solve(nums,0,k,memo));
    }
}
