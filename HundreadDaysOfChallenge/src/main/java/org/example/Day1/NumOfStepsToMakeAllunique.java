package org.example.Day1;

import java.util.Arrays;

public class NumOfStepsToMakeAllunique {
    public int solve(int[] A) {
        int n=A.length,res=0;
        Arrays.sort(A);
        for(int i=0;i<n-1;i++){
            if(A[i]>=A[i+1]){
                res+=A[i]-A[i+1]+1;
                A[i+1]=A[i]+1;
            }
        }
        return res;
    }

}
