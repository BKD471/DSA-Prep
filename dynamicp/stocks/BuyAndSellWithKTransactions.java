package dynamicp.stocks;
import java.util.Arrays;
public class BuyAndSellWithKTransactions {
    private static int solve(int[] nums,int index,int buy,int limit,int[][][] memo){
        if(index>=nums.length || limit<=0) return 0;
        if(memo[index][buy][limit]!=-1) return memo[index][buy][limit];
        if(buy==1){
            int bought=-nums[index]+solve(nums,index+1,0,limit,memo);
            int not_bought=solve(nums,index+1,1,limit,memo);
            memo[index][buy][limit]=Math.max(bought,not_bought);
        }else{
            int sold=nums[index]+solve(nums,index+1,1,limit-1,memo);
            int not_sold=solve(nums,index+1,0,limit,memo);
            memo[index][buy][limit]=Math.max(sold,not_sold);
        }
        return memo[index][buy][limit];
    }
    public static int maximumProfit(int[] prices, int n, int k){
        // Write your code here.
        int[][][] memo=new int[n+1][2][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=1;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return solve(prices,0,1,k,memo);
    }
}
