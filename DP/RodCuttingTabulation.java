public class RodCuttingTabulation {
    public static int cutRod(int price[], int n) {
        int[][] dp=new int[n][n+1];

        //weights arr is [0,1,2,3,4] start from 0 to end
        for(int i=0;i<=n;i++) dp[0][i]=i*price[0];


        for(int index=1;index<n;index++){
            for(int weight=0;weight<=n;weight++){
                int non_take=dp[index-1][weight];
                int take=Integer.MIN_VALUE;
                if(weight>=(index+1)) take=price[index]+dp[index][weight-(index+1)];

                dp[index][weight]=Math.max(take,non_take);
            }
        }

        return dp[n-1][n];
    }
}
