package org.example.D12;

public class MostWater {
    public int maxArea(int[] A) {
        int n=A.length;

        int l=0,h=n-1,mxWater=0;
        while(l<=h){
            int mn=Math.min(A[l],A[h]);
            mxWater=Math.max(mxWater,mn*(h-l));
            if(A[l]<A[h]) l++;
            else h--;
        }
        return mxWater;
    }
}
