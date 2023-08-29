package dynamicp;

import java.util.Arrays;

public class DiceSUm {
    private int limit=(int)(Math.pow(10,9)+7);
    private int calDiceSum(int[] dp,int sum){
        dp[0]=1;
        for(int i=1;i<=sum;i++){
            long s=0;
            for(int j=1;j<=6 && i>=j;j++){
                s=(s%limit+dp[i-j]%limit)%limit;
            }
            dp[i]=(int)s;
        }
        return dp[sum];
    }

    private int func(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return calDiceSum(dp,n);
    }

    public static void main(String[] args) {
        DiceSUm dc=new DiceSUm();
        System.out.println(dc.func(47));
    }
}
