package DP;

import java.util.Arrays;

public class CountWaysClimbingStairsMemoised {
    public static int climbIt(int n,int[] memo){
        if(memo[n]!=-1) return memo[n];
        if(n<=1) return 1;

        memo[n]=climbIt(n-1,memo)+climbIt(n-2,memo);
        return memo[n];
    }
    public static int climbStairs(int n) {
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return climbIt(n,memo);
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(8));
    }
}
