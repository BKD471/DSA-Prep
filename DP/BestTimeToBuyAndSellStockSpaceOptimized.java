public class BestTimeToBuyAndSellStockSpaceOptimized {

    // before procedding to understand how we can optimize space ,
    //lets understand the table used during tabulation

    //Its NX2 table  ,here cols denote 0->cannotBuy, 1->canbuy
    // le.g ->            int buy=-prices[index]+dp[index+1][0];
    //                    int not_buy=dp[index+1][1];
    //                    dp[index][canBuy]=Math.max(buy,not_buy);
    // we can clearly notice, we are using the previous row to calculate the current row
    //instead of taking an 2d array ,lets take  4 vars  prevbuy,prevnotbuy--> these wil have values at (notbuy)0th
    //and (canbuy) 1st col values of previous rows
    //currBuy,curnotbuy will have  current row values for coresponding cols
    // vars like  currBuy,curnotbuy will serve as previous state values for its upcoming next indexes
    //so copy them as prevState value for next Iteration



    public int maxProfit(int[] prices) {
        int n=prices.length;
        int prevBuy=0,prevNotBuy=0;

        for(int index=n-1;index>=0;index--){
            int buy=-prices[index]+prevNotBuy;
            int not_buy=prevBuy;
            int currBuy=Math.max(buy,not_buy);
            int sell=prices[index]+prevBuy;
            int not_sell=prevNotBuy;
            int currNotBuy=Math.max(sell,not_sell);

            prevBuy=currBuy;
            prevNotBuy=currNotBuy;

        }

        return prevBuy;
    }
}
