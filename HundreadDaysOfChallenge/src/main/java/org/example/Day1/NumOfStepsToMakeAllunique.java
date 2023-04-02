package org.example.Day1;

import java.util.Arrays;

public class NumOfStepsToMakeAllunique {
    ///Intuition: firts sort to bring all duplicates together
    //[1,1,1] at index =0 if A[i]==A[i+1] mens duplicate  count as A[i]-A[i+1]+1
    //A[i]-A[i+1] gives 0 and +1, 1 is counted for same vales at idx=1,idx=2
    //because we need one steps to make [1,1] to [1,2]
    //[1,2,1] at index=1 , A[i]>A[i+1],since we have sorted the array,
    // this is possible iff A[i] was earlier a duplicate of A[i-1]
    //A[i] got modified in previous steps so it is > A[i+1]
    // [1,2,1] at index=1 ,  A[i]-A[i+1]+1 is 1+1=2
    // we need two steps to make [2,1] to [2,3]    1->2  in 1st step, 2->3 in 2nd step
    //so total ===> 1 steps when i=0, 2 steps when i=2  ===>1+2==3
    // so count+=A[i]-A[i+1]+1
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
