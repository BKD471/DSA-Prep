public class BuyAndSellStockTransactionFeeSpaceOptimized {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;

        int prevBuy=0,prevNotBuy=0,currBuy=0,currNotBuy=0;


        for(int index=n-1;index>=0;index--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                if(canBuy==1){
                    int buy=-prices[index]+prevNotBuy;
                    int not_buy=prevBuy;
                    currBuy=Math.max(buy,not_buy);
                }else{
                    int sell=prices[index]-fee+prevBuy;
                    int not_sell=prevNotBuy;
                    currNotBuy=Math.max(sell,not_sell);
                }
            }
            prevBuy=currBuy;
            prevNotBuy=currNotBuy;
        }

        return  currBuy;
    }
}
