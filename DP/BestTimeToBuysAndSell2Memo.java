import java.util.Arrays;

//Here in this problem we are allowed to do multiple transactions
//but the condition is that we have to sell your holdings before we another stock

//this problem can be visualized as  are we able to buy or not
//a)if we have already bought,
// we have two options either sell it or hold it
//1)if we sell, we will be free to buy again in future indexes
//2) if we dont then we can't buy


//b)if we have sold or yet to buy anything. we have furhtur two options
// 1) buy it, if we buy  we have to sell it before buying again
//2) dont buy it, we are free to do buy in future indexes

// just take two indexes,one  denoting  the index of prices arr
// and other denoting have we bought or not.

public class BestTimeToBuysAndSell2Memo {
    public int maximizeProfit(int[] prices,int index,int canBuy,int[][] memo){

        if(index>=prices.length) return 0;

        if(memo[index][canBuy]!=-1) return memo[index][canBuy];

        if(canBuy==1){
            int buy=-prices[index]+maximizeProfit(prices,index+1,0,memo);
            int not_buy=maximizeProfit(prices,index+1,1,memo);
            return memo[index][canBuy]=Math.max(buy,not_buy);
        }else{
            int sell=prices[index]+maximizeProfit(prices,index+1,1,memo);
            int not_sell=maximizeProfit(prices,index+1,0,memo);
            return memo[index][canBuy]=Math.max(sell,not_sell);
        }

    }

    public int maxProfit(int[] prices) {
        int[][] memo=new int[prices.length][2];

        for(int i=0;i<prices.length;i++) Arrays.fill(memo[i],-1);
        return maximizeProfit(prices,0,1,memo);
    }
}
