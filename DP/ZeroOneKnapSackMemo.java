import java.util.Arrays;

public class ZeroOneKnapSackMemo {

    public static int knapSack(int[] wt,int[] val,int index,int weight,int[][] memo){
        //if(weight<0) return 0;
        if(index==0){
            if(wt[index]<=weight) return val[index];
            return 0;
        }

        if(memo[index][weight]!=-1) return memo[index][weight];

        int non_pick=knapSack(wt,val,index-1,weight,memo);
        int pick=Integer.MIN_VALUE;
        if(wt[index]<=weight)pick=val[index]+knapSack(wt,val,index-1,weight-wt[index],memo);

        memo[index][weight]=Math.max(pick,non_pick);
        return memo[index][weight];

    }


    //Function to return max value that can be put in knapsack of capacity W.
    static int knapsack(int[] wt, int[] val, int n, int W)
    {
        int[][] memo=new int[n][W+1];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
        return knapSack(wt,val,n-1,W,memo);
    }
}
