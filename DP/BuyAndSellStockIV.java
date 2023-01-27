import java.util.Arrays;

public class BuyAndSellStockIV {
    public int profit(int[] prices,int index,int canBuy,int k,int[][][] memo){

        if(index>=prices.length) return 0;
        if(k<=0) return 0;

        if(memo[index][canBuy][k]!=-1) return memo[index][canBuy][k];
        if(canBuy==1){
            int buy=-prices[index]+profit(prices,index+1,0,k,memo);
            int not_buy=profit(prices,index+1,1,k,memo);
            return memo[index][canBuy][k]=Math.max(buy,not_buy);
        }else{
            int sell=prices[index]+profit(prices,index+1,1,k-1,memo);
            int not_sell=profit(prices,index+1,0,k,memo);
            return memo[index][canBuy][k]=Math.max(sell,not_sell);
        }
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] memo=new int[n][2][k+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<=1;j++) {
                Arrays.fill(memo[i][j],-1);
            }
        }
        return profit(prices,0,1,k,memo);
    }
}
