package dynamicp.stocks;
import java.util.Arrays;
public class BuyAndSellWithFee {
    private static int solve(int[] nums,int index,int fee,int buy,int[][] memo){
        if(index>=nums.length) return 0;
        if(memo[index][buy]!=-1) return memo[index][buy];
        if(buy==1){
            int bought=-nums[index]+solve(nums,index+1,fee,0,memo);
            int not_bought=solve(nums,index+1,fee,1,memo);
            memo[index][buy]=Math.max(bought,not_bought);
        }else{
            int sold=nums[index]-fee+solve(nums,index+1,fee,1,memo);
            int not_sold=solve(nums,index+1,fee,0,memo);
            memo[index][buy]=Math.max(sold,not_sold);
        }
        return memo[index][buy];
    }
    public static int maximumProfit(int[] prices, int n, int fee) {
        // Write your code here.
        n=prices.length;
        int[][] memo=new int[n+1][2];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return solve(prices,0,fee,1,memo);
    }
}
