package org.example.Day2;

import java.util.Arrays;

public class MaxMinMagic {
    public static final int LIMIT=(int)Math.pow(10,9)+7;
    public int[] solve(int[] A) {
        int n=A.length;
        Arrays.sort(A);
        long mx=0,mn=0;
        for(int i=0;i<n/2;i++) mx=(mx%LIMIT+ Math.abs(A[i]-A[n-i-1])%LIMIT)%LIMIT;
        for(int i=0;i<n;i+=2) mn=(mn%LIMIT+Math.abs(A[i]-A[i+1])%LIMIT)%LIMIT;
        return new int[]{ (int)mx%LIMIT,(int)mn%LIMIT};
    }
}
