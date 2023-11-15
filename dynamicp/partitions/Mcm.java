package dynamicp.partitions;

import java.util.Arrays;
public class Mcm {
    private static int solve(int[] nums,int i,int j,int[][] memo){
        if(i>=j) return 0;

        if(memo[i][j]!=-1) return memo[i][j];
        int res=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int computations=solve(nums,i,k,memo)+solve(nums, k+1, j,memo)+nums[i-1]*nums[k]*nums[j];
            res=Math.min(res,computations);
        }
        return memo[i][j]=res;
    }

    public static int mcm(int[] nums){

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int[][] memo=new int[nums.length+1][nums.length+1];
        for(int i=0;i<=nums.length;i++) Arrays.fill(memo[i],-1);
        return solve(nums, 1, nums.length-1,memo);



        int n=nums.length;
        int[][] memo=new int[n][n];
        for(int i=0;i<n;i++) memo[i][i]=0;


        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int res=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int computations=memo[i][k]+memo[k+1][j]+nums[i-1]*nums[k]*nums[j];
                    res=Math.min(res,computations);
                }
                memo[i][j]=res;
            }
        }

        return memo[1][n-1];
    }
}
