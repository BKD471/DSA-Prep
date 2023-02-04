import java.util.Arrays;

public class MinCostToCutStick1 {

    public static int minCost(int[] cuts,int n) {
        int m = cuts.length;
        Arrays.sort(cuts);

        int[] costs = new int[m + 2];
        for (int i = 0; i < m; i++) costs[i + 1] = cuts[i];
        costs[0] = 0;
        costs[m + 1] = n;
        int[][] dp = new int[m + 2][m + 1];

        for (int start = m; start >= 1; start--) {
            for (int end = 1; end <= m; end++) {
                if (start > end) continue;
                int mnPrice = (int) (Math.pow(10, 9));
                for (int partition = start; partition <= end; partition++) {
                    int price = costs[end + 1] - costs[start - 1] + dp[start][partition - 1]
                            + dp[partition + 1][end];
                    mnPrice = Math.min(price, mnPrice);
                }
                dp[start][end] = mnPrice;
            }
        }

        return dp[1][m];
    }
}
