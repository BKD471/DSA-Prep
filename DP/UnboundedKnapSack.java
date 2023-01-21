import java.util.Arrays;

public class UnboundedKnapSack {
    public static int maxProfit(int[] profit,int[] weight,
                                int index,int w,int[][] memo){
        if(index==0){
            if(w>=weight[index]){
                int quantity=(int)(w/weight[index]);
                return quantity*profit[index];
            }
            //else we cant take it
            return 0;
        }

        if(memo[index][w]!=-1) return memo[index][w];
        int non_take=maxProfit(profit,weight,index-1,w,memo);
        int take=(int)Math.pow(-10,9);
        if(w>=weight[index]) take=profit[index]+maxProfit(profit,weight,index,w-weight[index],memo);
        memo[index][w]=Math.max(take,non_take);
        return memo[index][w];

    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] memo=new int[n][w+1];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);

        int v= maxProfit(profit,weight,n-1,w,memo);
        return v<0? 0:v;
    }
}
