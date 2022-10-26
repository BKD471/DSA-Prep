public class StockBuySell {

    public int mxProfit(int[] arr, int n) {

        int bp = arr[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (bp > arr[i]) bp = arr[i];
            else if (arr[i] - bp > maxProfit) {
                maxProfit = arr[i] - bp;
            }
        }

        return maxProfit;
    }
}
