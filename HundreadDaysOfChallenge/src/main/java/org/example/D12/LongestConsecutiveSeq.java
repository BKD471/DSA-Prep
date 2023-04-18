package org.example.D12;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
    public int longestConsecutive(final int[] A) {
        int n=A.length;
        Set<Integer> sack=new HashSet<>();
        for(int i=0;i<n;i++) sack.add(A[i]);

        int mxLenth=-1;
        for(int i=0;i<n;i++){
            if(!sack.contains(A[i]-1)){
                int cnt=0,v=A[i];
                while(sack.contains(v)){
                    v+=1;
                    cnt++;
                }
                mxLenth=Math.max(mxLenth,cnt);
            }
        }
        return mxLenth;
    }
}
