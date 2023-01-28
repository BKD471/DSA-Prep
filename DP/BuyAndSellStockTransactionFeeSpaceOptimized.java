public class BuyAndSellStockTransactionFeeSpaceOptimized {
        public int maxProfit(int[] prices) {
            int n=prices.length;

            int[] prev =new int[2];
            int[] prevOfPrev=new int[2];
            int[] curr=new int[2];

            for(int index=n-1;index>=0;index--){
                for(int canBuy=0;canBuy<=1;canBuy++){
                    if(canBuy==1){
                        int buy=-prices[index]+prev[0];
                        int not_buy=prev[1];
                        curr[canBuy]=Math.max(buy,not_buy);
                    }else{
                        int sell=prices[index]+prevOfPrev[1];
                        int not_sell=prev[0];
                        curr[canBuy]=Math.max(sell,not_sell);
                    }
                }
                prevOfPrev=(int[] )(prev.clone());
                prev=(int[])(curr.clone());
            }

            return curr[1];
        }
}
