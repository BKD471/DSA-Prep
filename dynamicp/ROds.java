package dynamicp;

import java.util.Arrays;

public class ROds {

        private static int solve(int[] nums,int i,int n,int[][] memo){
            if(i>=nums.length) return 0;
            if(n<=0) return 0;

            if(memo[i][n]!=-1) return memo[i][n];
            int rodLength=i+1;
            int take=Integer.MIN_VALUE;
            if(rodLength<=n) take=nums[i]+solve(nums,i,n-rodLength,memo);
            int not_take=solve(nums,i+1,n,memo);
            memo[i][n]=Math.max(take,not_take);
            return memo[i][n];
        }
        public static int cutRod(int price[], int n) {
            // Write your code here.
            int[][] memo=new int[n+1][n+1];
            for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
            return solve(price, 0, n,memo);
        }
}
