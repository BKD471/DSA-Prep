package dynamicp.stocks;
import java.util.Arrays;
public class BuyAndSellUnLimitedTransactions {
    private static long solve(long[] nums,int index,int buy,long[][] memo){
        if(index>=nums.length) return 0;
        if(memo[index][buy]!=-1) return memo[index][buy];
        if(buy==1){
            long bought=-nums[index]+solve(nums,index+1,0,memo);
            long not_bought=solve(nums,index+1,1,memo);
            memo[index][buy]=Math.max(bought,not_bought);
        }else{
            long sold=nums[index]+solve(nums,index+1,1,memo);
            long not_sold=solve(nums,index+1,0,memo);
            memo[index][buy]=Math.max(sold,not_sold);
        }
        return memo[index][buy];
    }
    public static long getMaximumProfit (int n, long[] nums) {
        // Your code goes here.
        long[][] memo=new long[n+1][2];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return solve(nums,0,1,memo);
    }
}
