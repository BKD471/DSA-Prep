import java.util.Arrays;

public class StockBuyAndSell3Memo {
    public int maximizeProfit(int[] prices,int index,int canBuy,int limit,int[][][] memo){
        //arrays is exhausted ,no more profit we can make
        if(index>=prices.length) return 0;

        //we have reached max limit of transactions
        if(limit<=0) return 0;

        if(memo[index][canBuy][limit]!=-1) return memo[index][canBuy][limit];

        if(canBuy==1){
            //we have bought so cant buy another until we sell, and also we havent finished any
            // transations so no change in limit
            int buy=-prices[index]+maximizeProfit(prices,index+1,0,limit,memo);
            int not_buy=maximizeProfit(prices,index+1,1,limit,memo);
            return memo[index][canBuy][limit]=Math.max(buy,not_buy);
        }else{
            // we have sold ,thus we complete one transaction reduce the limit
            int sell=prices[index]+maximizeProfit(prices,index+1,1,limit-1,memo);
            int not_sell=maximizeProfit(prices,index+1,0,limit,memo);
            return memo[index][canBuy][limit]=Math.max(sell,not_sell);
        }
    }

    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] memo=new int[n][2][3];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return maximizeProfit(prices,0,1,2,memo);
    }
}
