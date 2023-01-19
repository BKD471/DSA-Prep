public class ZeroOneKnapSackTabula {

    static int knapsack(int[] wt, int[] val, int n, int W)
    {

        //dp[index][weight]
        int[][] dp=new int[n][W+1];
        //for any weight>= weight[0] steal it
        // just look at how memoization problem is solved
        //and you will undertsand why this base case
        for(int i=wt[0];i<=W;i++) dp[0][i]=val[0];

        for(int i=1;i<n;i++){
            for(int weight=0;weight<=W;weight++){
                int non_pick=dp[i-1][weight];
                int pick=Integer.MIN_VALUE;
                if(weight>=wt[i]) pick=val[i]+dp[i-1][weight-wt[i]];

                dp[i][weight]=Math.max(pick,non_pick);
            }
        }
        return dp[n-1][W];
    }
}
