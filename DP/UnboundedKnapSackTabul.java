public class UnboundedKnapSackTabul {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.

        int[][] dp=new int[n][w+1];
        for(int i=weight[0];i<=w;i++){
            int quantity=(int)(i/weight[0]);
            dp[0][i]=quantity*profit[0];
        }

        for(int index=1;index<n;index++){
            for(int wei=0;wei<=w;wei++){
                int non_take=dp[index-1][wei];
                int take=Integer.MIN_VALUE;
                if(wei>=weight[index])take=profit[index]+dp[index][wei-weight[index]];
                dp[index][wei]=Math.max(take,non_take);
            }
        }
        return dp[n-1][w];
    }
}
