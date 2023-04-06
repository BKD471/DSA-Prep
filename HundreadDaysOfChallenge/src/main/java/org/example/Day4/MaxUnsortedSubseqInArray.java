package org.example.Day4;

public class MaxUnsortedSubseqInArray {
    public int[] subUnsort(int[] A) {
        int n=A.length;

        int mn=Integer.MAX_VALUE;
        boolean flag=true;
        for(int i=1;i<n;i++){
            if(A[i]<A[i-1]) flag=false;
            if(!flag) mn=Math.min(mn,A[i]);
        }


        flag=true;
        int mx=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            if(A[i]>A[i+1]) flag=false;
            if(!flag) mx=Math.max(mx,A[i]);
        }
        if(mx==Integer.MIN_VALUE || mn==Integer.MAX_VALUE) return new int[]{-1};

        int l=0,h=0;
        for(int i=0;i<n;i++) {
            if(A[i]>mn){
                l=i;
                break;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(A[i]<mx){
                h=i;
                break;
            }
        }

        return new int[]{l,h};
    }
}
