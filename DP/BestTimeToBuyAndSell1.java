
// Here we are allowed only one transaction--> 1 time buy and 1 time sell

//Intution---> buy it on lowest price day and sell it on max to maximize the profiy

public class BestTimeToBuyAndSell1 {
    public int maxProfit(int[] prices) {

        int min=prices[0],profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min) profit=Math.max(profit,prices[i]-min);
            min=Math.min(prices[i],min);
        }
        return profit;
    }
}
