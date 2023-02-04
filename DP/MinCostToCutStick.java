import java.util.Arrays;

public class MinCostToCutStick {
    public int minCost(int[] costs,int start,int end,int[][] memo){
        if(start>end) return 0;
        if(memo[start][end]!=-1) return memo[start][end];

        int mnPrice=(int)(Math.pow(10,9));
        for(int partition=start;partition<=end;partition++){
            int price=costs[end+1]-costs[start-1]+minCost(costs,start,partition-1,memo)
                    +minCost(costs,partition+1,end,memo);
            mnPrice=Math.min(price,mnPrice);
        }
        return memo[start][end]=mnPrice;
    }
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] costs=new int[m+2];
        Arrays.sort(cuts);
        for(int i=0;i<m;i++) costs[i+1]=cuts[i];
        costs[0]=0;costs[m+1]=n;

        int[][] memo=new int[m+1][m+1];
        for(int i=0;i<m+1;i++) Arrays.fill(memo[i],-1);

        return minCost(costs,1,m,memo);
    }
}
