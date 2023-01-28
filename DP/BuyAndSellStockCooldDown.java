import java.util.Arrays;

public class BuyAndSellStockCooldDown {

        public int profit(int[] prices,int index,int canBuy,int[][] memo){

            if(index>=prices.length) return 0;

            if(memo[index][canBuy]!=-1) return memo[index][canBuy];

            if(canBuy==1){
                int buy=-prices[index]+profit(prices,index+1,0,memo);
                int not_buy=profit(prices,index+1,1,memo);
                return memo[index][canBuy]=Math.max(buy,not_buy);
            }else{
                int sell=prices[index]+profit(prices,index+2,1,memo);
                int not_sell=profit(prices,index+1,0,memo);
                return memo[index][canBuy]=Math.max(sell,not_sell);
            }
        }
        public int maxProfit(int[] prices) {
            int n=prices.length;

            int[][] memo=new int[n][2];
            for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
            return profit(prices,0,1,memo);
        }
}
