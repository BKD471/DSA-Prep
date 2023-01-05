import java.util.Arrays;

public class Fib0 {

    public static  int fib(int n,int[] memo){
        if(memo[n]!=-1) return memo[n];
        if(n<=1) return n;
        memo[n]=fib(n-1,memo)+fib(n-2,memo);
        return memo[n];
    }

    public  static int finTabulation(int n){
        int[] dp=new int[n+1];
        dp[0]=0;dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=800;
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        System.out.println(Fib0.fib(n,memo));


        System.out.println(Fib0.finTabulation(n));
    }

}
