import java.util.Arrays;

public class RodCutting {
    public static int maxProfit(int[] price,int index,int weight,int[][] memo){

        if(index==0){
            if(weight>=(index+1)){
                int quantity=(int)(weight/(index+1));
                return quantity*price[index];
            }
            return 0;
        }

        if(memo[index][weight]!=-1) return memo[index][weight];

        int non_take=maxProfit(price,index-1,weight,memo);
        int take=Integer.MIN_VALUE;
        if(weight>=(index+1)) take=price[index]+maxProfit(price,index,weight-(index+1),memo);
        memo[index][weight]=Math.max(non_take,take);
        return memo[index][weight];
    }
    public static int cutRod(int price[], int n) {
        int[][] memo=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return maxProfit(price,n-1,n,memo);
    }
}
