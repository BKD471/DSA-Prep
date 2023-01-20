public class CoinChangeII {
    public int change(int amount, int[] coins) {

        int[][] dp=new int[coins.length][amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0) dp[0][t]=1;
            else dp[0][t]=0;
        }

        for(int index=1;index<coins.length;index++){
            for(int targ=0;targ<=amount;targ++){
                int pick=0;
                if(targ>=coins[index]) pick=dp[index][targ-coins[index]];
                int  non_pick=dp[index-1][targ];

                dp[index][targ]=pick+non_pick;
            }
        }

        return dp[coins.length-1][amount];
    }
}
