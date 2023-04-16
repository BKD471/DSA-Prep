package org.example.Day11;

import java.util.Arrays;

public class AggressiveCows {
    public class Solution {
        public boolean isPossible(int[] A,int d,int k){
            int prevCow=A[0],cnt=1;
            for(int i=1;i<A.length;i++){
                if(A[i]-prevCow>=d){
                    cnt++;
                    prevCow=A[i];
                }
                if(k==cnt) return true;
            }
            return false;
        }
        public int solve(int[] A, int B) {
            int n=A.length;
            Arrays.sort(A);
            int l=1,h=A[n-1]-A[0],mxDistance=0;
            while(l<=h){
                int distance=(l+h)>>1;
                if(isPossible(A,distance,B)){
                    mxDistance=distance;
                    l=distance+1;
                }else h=distance-1;
            }
            return mxDistance;
        }
    }

}
