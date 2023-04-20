package org.example.Day13;

import java.util.HashSet;
import java.util.Set;

public class CountRectanges {
    public int solve(int[] A, int[] B) {
        int n=A.length;
        Set<String> hash=new HashSet<>();

        for(int i=0;i<n;i++) {
            hash.add(A[i]+"-"+B[i]);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(A[i]<A[j] && B[i]<B[j] && (hash.contains(A[i]+"-"+B[j]) && hash.contains(A[j]+"-"+B[i]))) cnt++;
            }
        }
        return cnt;
    }
}
