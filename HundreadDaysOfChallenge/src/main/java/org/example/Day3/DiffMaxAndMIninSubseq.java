package org.example.Day3;

import java.util.Arrays;

public class DiffMaxAndMIninSubseq {
    private static final int LIMIT=(int)Math.pow(10,9)+7;
    public int solve(int[] A) {
        int n=A.length;
        Arrays.sort(A);

        long max=0,x=1;
        for(int i=0;i<n;i++){
            long v=((A[i]%LIMIT)*(x%LIMIT))%LIMIT;
            max=(max%LIMIT+v%LIMIT)%LIMIT;
            x=x*2;
        }

        long min=0;
        x=1;
        for(int i=n-1;i>=0;i--){
            long v=((A[i]%LIMIT)*(x%LIMIT))%LIMIT;
            min=(min%LIMIT+v%LIMIT)%LIMIT;
            x=x*2;
        }

        return (int)(max-min);
    }
}
