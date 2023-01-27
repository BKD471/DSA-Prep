public class BuyAndSellStockIVTabulation {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];

        //when we have exhausted the array i.e no more stocks to transact
        for(int canBuy=0;canBuy<=1;canBuy++){
            for(int limit=0;limit<=k;limit++){
                dp[n][canBuy][limit]=0;
            }
        }

        //when we have reached max transaction limit
        for(int index=0;index<n+1;index++){
            for(int canBuy=0;canBuy<=1;canBuy++){
                dp[index][canBuy][0]=0;
            }
        }

        // the above two base cases are not required, since the default value of int[] dp array is zero
        //so its already initialized with zero so no need to explicitly assign the base cases with zero
        //I've added this  just for fun :)


        for(int index=n-1;index>=0;index--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                for(int limit=1;limit<=k;limit++){
                    if(canBuy==1){
                        int buy=-prices[index]+dp[index+1][0][limit];
                        int not_buy=dp[index+1][1][limit];
                        dp[index][canBuy][limit]=Math.max(buy,not_buy);
                    }else{
                        int sell=prices[index]+dp[index+1][1][limit-1];
                        int not_sell=dp[index+1][0][limit];
                        dp[index][canBuy][limit]=Math.max(sell,not_sell);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}
