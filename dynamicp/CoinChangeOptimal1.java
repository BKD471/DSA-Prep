package dynamicp;

import java.util.*;

public class CoinChangeOptimal1 {
    private int solve(int[] nums,int index,int target,int[][] dp){
        if(target==0) return 1;
        if(target<0) return 0;
        if(index>=nums.length) return 0;
        if(dp[index][target]!=-1) return dp[index][target];

        int take=solve(nums,index,target-nums[index],dp);
        int non_take=solve(nums,index+1,target,dp);
        dp[index][target]=take+non_take;
        return take+non_take;
    }
    private int combo(int[] nums,int k){
        //Arrays.sort(nums);
        int[][] dp=new int[nums.length+1][k+1];
        for(int i=0;i<=nums.length;i++) Arrays.fill(dp[i],-1);
        return solve(nums,0,k,dp);
    }
    public static void main(String[] args) {

        int[] nums={1 ,2, 3, 4 ,5 ,6 ,7 ,8};
        CoinChangeOptimal1 coinChangeI=new CoinChangeOptimal1();
        int op=coinChangeI.combo(nums,301);
        System.out.println(op);
    }
}
