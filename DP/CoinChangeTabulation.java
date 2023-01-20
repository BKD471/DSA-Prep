public class CoinChangeTabulation {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)  dp[0][i]=i/coins[0];
            else dp[0][i]=(int)Math.pow(10,9);
        }

        for(int index=1;index<n;index++){
            for(int target=0;target<=amount;target++){
                int non_pick=dp[index-1][target];
                int pick=(int)Math.pow(10,9);
                if(coins[index]<=target) pick=1+dp[index][target-coins[index]];
                dp[index][target]=Math.min(pick,non_pick);
            }
        }
        return dp[n-1][amount]>=(int)Math.pow(10,9)? -1:dp[n-1][amount];
    }
}
