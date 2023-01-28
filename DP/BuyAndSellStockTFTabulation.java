public class BuyAndSellStockTFTabulation {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;

        int[][] dp=new int[n+1][2];

        for(int i=0;i<=1;i++){
            dp[n][i]=0;
        }
        //no need to add the upper base case,its already been intialzed as zero
        //just for demo

        for(int index=n-1;index>=0;index--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                if(canBuy==1){
                    int buy=-prices[index]+dp[index+1][0];
                    int not_buy=dp[index+1][1];
                    dp[index][canBuy]=Math.max(buy,not_buy);
                }else{
                    int sell=prices[index]-fee+dp[index+1][1];
                    int not_sell=dp[index+1][0];
                    dp[index][canBuy]=Math.max(sell,not_sell);
                }
            }
        }

        return dp[0][1];
    }
}
