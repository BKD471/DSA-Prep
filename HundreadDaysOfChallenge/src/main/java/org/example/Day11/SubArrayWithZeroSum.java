package org.example.Day11;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {
    public int solve(int[] A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        int n=A.length;
        Set<Long> hash=new HashSet<>();
        long cum_sum=0;
        hash.add(0l);
        for(int i=0;i<n;i++){
            cum_sum+=A[i];
            if(hash.contains(cum_sum)) return 1;
            hash.add(cum_sum);
        }
        return 0;
    }
}
