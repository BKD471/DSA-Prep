import java.util.Arrays;

public class CoinChangeMemo {
        public int coinCombo(int[] coins,int index,int target,int[][] memo){
            if(index==0){
                //check if last no can be evenly divided by remaining target
                //if yes the divison of both will be no of coins we can derive from them
                if(target%coins[index]==0) return target/coins[index];
                //else we cannot derive any coins
                return (int)Math.pow(10,9);
            }

            if(memo[index][target]!=-1) return memo[index][target];

            int non_pick=coinCombo(coins,index-1,target,memo);
            int pick=(int)Math.pow(10,9);
            if(target>=coins[index])pick=1+coinCombo(coins,index,target-coins[index],memo);
            memo[index][target]=Math.min(pick,non_pick);
            return memo[index][target];
        }
        public int coinChange(int[] coins, int amount) {
            int n=coins.length;
            int[][] memo=new int[n][amount+1];
            for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);

            int v= coinCombo(coins,n-1,amount,memo);
            return v>=Math.pow(10,9) ? -1:v;
        }
}
