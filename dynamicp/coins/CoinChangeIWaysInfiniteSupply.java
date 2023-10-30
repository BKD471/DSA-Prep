package dynamicp.coins;
import  java.util.Arrays;
public class CoinChangeIWaysInfiniteSupply {
    private static long solve(int[] nums,int index,int v,long[][] memo){
        if(index==nums.length-1){
            if((v%nums[nums.length-1])==0) return 1;
            else return 0;
        }

        if(memo[index][v]!=-1) return memo[index][v];
        long take=0;
        if(nums[index]<=v) take=solve(nums,index,v-nums[index],memo);
        long not_take=solve(nums,index+1,v,memo);
        memo[index][v]=(take+not_take);
        return memo[index][v];
    }

    public static long countWaysToMakeChange(int nums[], int v){
        //write your code here
        int n=nums.length;
        long[][] memo=new long[n+1][v+1];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i], -1);
        return solve(nums,0,v,memo);
    }
}
