package org.example.Day13;

import java.util.HashMap;
import java.util.Map;

public class CountRightAngles {
    public int solve(int[] A, int[] B) {
        Map<Integer,Integer> hashx=new HashMap<>();
        Map<Integer,Integer> hashy=new HashMap<>();;

        int n=B.length;
        for(int i=0;i<n;i++){

            if(hashx.containsKey(A[i])){
                hashx.put(A[i],hashx.get(A[i])+1);
            }else hashx.put(A[i],1);

            if(hashy.containsKey(B[i])){
                hashy.put(B[i],hashy.get(B[i])+1);
            }else hashy.put(B[i],1);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans+=(hashx.get(A[i])-1)*(hashy.get(B[i])-1);
        }

        return ans;
    }
}
