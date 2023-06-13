package DP;

import java.util.Arrays;



public class FrogJumpMemoized {
    public static int jump(int n,int[] heights,int[] memo){

        if(n==0) return 0;
        if(memo[n]!=-1) return memo[n];

        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        left=jump(n-1,heights,memo)+Math.abs(heights[n]-heights[n-1]);
        if(n>1) right=jump(n-2,heights,memo)+Math.abs(heights[n]-heights[n-2]);

        memo[n]=Math.min(left,right);
        return memo[n];
    }
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        return jump(n-1,heights,memo);
    }
    public static void main(String[] args) {
        int[] heights={10,20,60,50,60};
        System.out.println(frogJump(5,heights));
    }
}
