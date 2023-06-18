package Exponentiation;

import java.time.LocalDate;

public class calPow {
    private static final Long m=(long)Math.pow(10,9)+7;
    private static long calPowBrute(long a, long b) {
        long res = 1;
        for (int i = 0; i < b; i++) {
            res =(res%m * a%m)%m;
        }
        return res;
    }

    private static long calPowOptimal(long a, long b) {
        if (a == 0) return 0;
        if (b == 0) return 1;
        long res = calPowOptimal(a,b/2);
        //even
        if ((b & 1) == 0) return (res%m * res%m)%m;
        else return (res%m * res%m * a%m)%m;
    }

    private static long calPowOptimalIterative(long a,long b){
      long ans=1;
        while(b>0){
            if((b&1)==1){
                ans=(ans%m*a%m)%m;
            }
            b=b>>1;
            a=(a%m*a%m)%m;
        }
        return ans;
    }
    public static void main(String[] args) {
        long a=2,b=31;
        long res1 = calPowBrute(a, b);
        long res2 = calPowOptimal(a, b);
        long res3=calPowOptimalIterative(a,b);
        System.out.println(res1 + ": " + res2);
        System.out.println(res3);
    }
}
