package dynamicp;

public class StockBuyAndSell1 {
        public int maxProfit(int[] prices) {
            int n=prices.length;
            int mxProfit=0;
            if(n==0) return mxProfit;

            int buy=prices[0];
            for(int i=1;i<n;i++){
                if(prices[i]<buy) buy=prices[i];
                mxProfit=Math.max(mxProfit,prices[i]-buy);
            }

            return mxProfit;
        }
}
