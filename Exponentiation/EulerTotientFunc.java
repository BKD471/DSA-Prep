package Exponentiation;

public class EulerTotientFunc {

    //ETF
    //q(n)=n*sigma(1-1/p)
    //p->prime factors of n

    //a^b %m
    //Eulers theorem
    // a^b congruent to a^(b % q(n)) mod n

    //(a^b)%n= (a^(b%q(n)))%n

    // when n is prime
    //q(n)=n(1-1/n)==>n-1

    //so when n is prime, a^b % n
     // (a^(b% q(n)))%n
    // q(n)=n-1
    // (a^(b%(n-1))) %n


    // when b is very large
    private static long binExp(long a,long b,long m){
        long ans=1;
        while(b>0){
            if((b&1)==1){
                ans=(a%m*ans%m)%m;
            }
            b=b>>1;
            a=(a%m*a%m)%m;
        }
        return  ans;
    }

    private int binExps(int a,int b,int m){
        a=a%m;
        int ans=1;
        while(b>0){
            if((b&1)==1){
                ans=(ans%m*a%m)%m;
            }
            b=b>>1;
            a=(a%m*a%m)%m;
        }
        return ans;
    }

    public int superPow(int a, int[] b) {
        int exp=0;
        for(int v:b){
            exp=(exp*10+v)%1140;
        }

        return binExps(a, exp,1337);
    }

    public static void main(String[] args){
        //50^64^32 % 6997
        System.out.println(binExp(50,binExp(64,32,6997-1),6997));

        //(1337) = 1337(1-1/7)(1-1/191)
        //       =1337*(6/7)*(190/191)=1140
    }
}
