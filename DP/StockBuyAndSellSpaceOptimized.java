public class StockBuyAndSellSpaceOptimized {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] prev = new int[2][3];
        int[][] curr = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int limit = 1; limit <= 2; limit++) {
                    if (canBuy == 1) {
                        int buy = -prices[index] + prev[0][limit];
                        int not_buy = prev[1][limit];
                        curr[canBuy][limit] = Math.max(buy, not_buy);
                    } else {
                        int sell = prices[index] + prev[1][limit - 1];
                        int not_sell = prev[0][limit];
                        curr[canBuy][limit] = Math.max(sell, not_sell);
                    }
                    prev[canBuy][limit] = curr[canBuy][limit];
                }
            }
        }
        return prev[1][2];
    }
}
