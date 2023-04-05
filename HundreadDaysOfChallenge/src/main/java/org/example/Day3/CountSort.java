package org.example.Day3;

public class CountSort {
    public int[] solve(int[] A) {
        int n=A.length;
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) mx=Math.max(mx,A[i]);

        int[] hash=new int[mx+1];
        for(int i=0;i<n;i++){
            hash[A[i]]++;
        }
        int l=0;
        for(int i=0;i<=mx;i++){
            int cnt=hash[i];
            while(cnt>0){
                A[l++]=i;
                cnt--;
            }
        }
        return A;
    }
}
