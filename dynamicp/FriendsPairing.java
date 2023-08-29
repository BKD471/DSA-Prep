package dynamicp;

public class FriendsPairing {
    public  long calPair(int n){
        long limit=(long)(Math.pow(10,9)+7);
        long[] dp=new long[n+2];

        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]%limit+((i-1)*dp[i-2])%limit)%limit;
        }
        return dp[n];
    }
}
