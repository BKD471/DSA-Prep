package org.example.Day1;

import java.util.Arrays;

public class MinAbsDifference {
       //Intuition:
       //sort the array first
       //coz in sorted form ,differnce between two of the consecutive will be minimum
        public int solve(int[] A) {
            int n=A.length;
            int mn=Integer.MAX_VALUE;
            Arrays.sort(A);
            for(int i=0;i<n-1;i++){
                int diff=A[i+1]-A[i];
                mn=Math.min(mn,diff);
            }

            return mn;
        }
}
