import java.util.Arrays;

public class CoinChangeIIs {
    public int coinCombo(int[] coins,int index,int amount,int[][] memo){

        if(index==0){
            if(amount%coins[index]==0) return 1;
            return 0;
        }

        if(memo[index][amount]!=-1) return memo[index][amount];

        int pick=0;
        if(amount>=coins[index]) pick=coinCombo(coins,index,amount-coins[index],memo);
        int non_pick=coinCombo(coins,index-1,amount,memo);
        memo[index][amount]=pick+non_pick;
        return memo[index][amount];
    }
    public int change(int amount, int[] coins) {
        int[][] memo=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++) Arrays.fill(memo[i],-1);
        return coinCombo(coins,coins.length-1,amount,memo);
    }
}
