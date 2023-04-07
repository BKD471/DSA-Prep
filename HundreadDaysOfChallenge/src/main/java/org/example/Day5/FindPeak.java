package org.example.Day5;

public class FindPeak {
    public int solve(int[] A) {
        int n=A.length;
        int l=0,h=n-1;

        while(l<h){
            int mid=l+(h-l)/2;
            if(A[mid]<A[mid+1]) l=mid+1;
            else  h=mid;
        }
        return A[h];
    }
}
