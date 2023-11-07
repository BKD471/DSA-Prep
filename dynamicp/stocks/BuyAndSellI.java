package dynamicp.stocks;

import java.util.ArrayList;

public class BuyAndSellI {
    public int stock(ArrayList<Integer> prices){
        int n=prices.size();
        if(n<=1) return 0;

        int buy=prices.get(0);
        int maxProfit=0;
        for(int i=1;i<n;i++){
            maxProfit=Math.max(maxProfit,prices.get(i)-buy);
            if(prices.get(i)<buy) buy=prices.get(i);
        }
        return maxProfit;
    }
}
