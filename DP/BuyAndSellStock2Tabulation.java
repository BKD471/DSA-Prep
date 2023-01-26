//Just same approch like done during memoization

//Here in this problem we are allowed to do multiple transactions
//but the condition is that you have to sell your holdings before you another stock

//this problem can be visualized as  are you able to buy or not
//a)if you have already bought,
// you have two options either sell it or hold it
//1)if you sell, you will be free to buy again in future indexes
//2) if you dont then you can't buy


//b)if you have sold or yet to buy anything. you have furhtur two options
// 1) buy it, if you buy  you have to sell it before buying again
//2) dont buy it, you are free to do buy in future indexes

// just take two indexes,one  denoting  the index of prices arr
// and other denoting have you bought or not.


public class BuyAndSellStock2Tabulation {

    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];

        dp[n][0]=0;dp[n][1]=0;

        for(int index=n-1;index>=0;index--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                if(canBuy==1){
                    int buy=-prices[index]+dp[index+1][0];
                    int not_buy=dp[index+1][1];
                    dp[index][canBuy]=Math.max(buy,not_buy);
                }else{
                    int sell=prices[index]+dp[index+1][1];
                    int not_sell=dp[index+1][0];
                    dp[index][canBuy]=Math.max(sell,not_sell);
                }
            }
        }

        return dp[0][1];
    }
}
