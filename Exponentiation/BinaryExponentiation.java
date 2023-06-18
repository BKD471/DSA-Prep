package Exponentiation;


public class BinaryExponentiation {
    private static final Long m1e9=(long)Math.pow(10,9)+7;
    private static final Long m1e18=(long)Math.pow(10,18)+7;
    private static long calPowBrute(long a, long b) {
        long res = 1;
        for (int i = 0; i < b; i++) {
            res =(res%m1e9 * a%m1e9)%m1e9;
        }
        return res;
    }

    private static long calPowOptimal(long a, long b) {
        if (a == 0) return 0;
        if (b == 0) return 1;
        long res = calPowOptimal(a,b/2);
        //even
        if ((b & 1) == 0) return (res%m1e9 * res%m1e9)%m1e9;
        else return (res%m1e9 * res%m1e9 * a%m1e9)%m1e9;
    }

    //Case 1 when a~10^9 b~10^9 m~10^9
    private static long calPowOptimalIterativeCase1(long a,long b){
      long ans=1;
        while(b>0){
            if((b&1)==1){
                ans=(ans%m1e9*a%m1e9)%m1e9;
            }
            b=b>>1;
            a=(a%m1e9*a%m1e9)%m1e9;
        }
        return ans;
    }

    //case 2 when a~10^18  b~10^9  m~10^18
    private static long calPowOptimalIterativeCase2(long a,long b){
        long ans=1;
        while(b>0){
            if((b&1)==1){
                ans=binaryMultiplication(ans,a);
            }
            b=b>>1;
            a=binaryMultiplication(a,a);
        }
        return ans;
    }

    private static long binaryMultiplication(long a,long b){
        long ans=0;
        while(b>0){
            if((b&1)==1){
                ans=(ans%m1e18+a%m1e18)%m1e18;
            }
            b=b>>1;
            a=(a%m1e18+a%m1e18)%m1e18;
        }
        return ans;
    }

    public static void main(String[] args) {
        long a=3,b=13;
        long res1 = calPowBrute(a, b);
        long res2 = calPowOptimal(a, b);
        long res3=calPowOptimalIterativeCase1(a,b);
        System.out.println(res1 + ": " + res2);
        System.out.println(res3);

        long res4=calPowOptimalIterativeCase2(1234567891011121234L,50);
        System.out.println(res4);
    }
}

/*
  3^13

  a               b      res
  3               1101   1
  9               110    3
  81              11     3
  81*81           1      3*81
  (81*81)*(81&81) 0      3*81*81*81  =>1594323

3^13
3^(1101)
3^(1*2^3)*3^(1*2^2)*3^(0*2^1)*3^(1*2^0)
3^8 * 3^4 * 3^0 * 3^1
 */
