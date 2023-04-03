package org.example.Day2;

public class MxchunksToSort {
    public int solve(int[] A) {
        int n=A.length,mx=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            mx=Math.max(A[i],mx);
            if(i>=mx) cnt++;
        }

        return cnt;
    }
}
