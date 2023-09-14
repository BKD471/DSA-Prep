package dynamicp;
import java.util.Arrays;
public class StockBuyAndSellII {
    private int solve(int[] nums,int index,int buy,int[][] memo){
        if(index>=nums.length) return 0;

        if(memo[index][buy]!=-1) return memo[index][buy];
        int mxProfit=Integer.MIN_VALUE;
        if(buy==1){
            int bought=-nums[index]+solve(nums,index+1,0,memo);
            int not_bought=solve(nums,index+1,1,memo);
            mxProfit=Math.max(bought,not_bought);
        }else{
            int sold=nums[index]+solve(nums,index+1,1,memo);
            int not_sold=solve(nums,index+1,0,memo);
            mxProfit=Math.max(sold,not_sold);
        }

        memo[index][buy]=mxProfit;
        return memo[index][buy];
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0) return 0;
        int[][] memo=new int[n+1][2];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return solve(prices,0,1,memo);
    }
}
