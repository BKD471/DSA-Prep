package org.example.Day5;

public class SingleElementInSortedArray {
    public int solve(int[] A,int n){
        if(n>1 && (A[0]!=A[1])) return A[0];
        if(n>1 &&  (A[n-1]!=A[n-2])) return A[n-1];
        int l=0,h=n-1;
        while(l<=h){

            int mid=l+(h-l)/2;
            if(A[mid]!=A[mid-1] && A[mid]!=A[mid+1]) return A[mid];

            if( (mid%2==0 && A[mid]==A[mid+1]) || (mid%2!=0 && A[mid-1]==A[mid])) l=mid+1;
            else  h=mid-1;
        }
        return -1;
    }
    public int solve(int[] A) {
        int n=A.length;
        return solve(A,n);
    }
}
