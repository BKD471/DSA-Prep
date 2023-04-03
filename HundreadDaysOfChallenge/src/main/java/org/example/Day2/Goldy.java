package org.example.Day2;

import java.util.Arrays;

public class Goldy {
    public boolean[] sieve(int n){
        boolean[] primes=new boolean[n+1];
        Arrays.fill(primes,true);

        for(int t=2;t<=Math.sqrt(n);t++){
            if(primes[t]==true){
                for(int i=t*t;i<=n;i+=t){
                    primes[i]=false;
                }
            }
        }
        return primes;
    }
    public int[] primesum(int A) {
        boolean primes[]=sieve(A);

        if(A==4) return new int[]{2,2};

        int i=2,j=A-2;
        while(i<j){
            if(primes[i]==true && primes[j]==true){
                if(i+j==A) return new int[]{i,j};
            }
            j--;
            i++;
        }
        return new int[]{-1,-1};
    }
}
