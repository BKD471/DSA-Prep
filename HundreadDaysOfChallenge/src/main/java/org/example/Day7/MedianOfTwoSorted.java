package org.example.Day7;

import java.util.List;

public class MedianOfTwoSorted {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n=a.size(),m=b.size();

        if(n>m) return findMedianSortedArrays(b,a);
        int total=n+m+1;
        int l=0,h=Math.min(n,total/2);

        while(l<=h){
            int c1=l+(h-l)/2;
            int c2=total/2-c1;

            int l1=(c1==0)? Integer.MIN_VALUE:a.get(c1-1);
            int l2=(c2==0)? Integer.MIN_VALUE:b.get(c2-1);
            int r1=(c1==n)?Integer.MAX_VALUE:a.get(c1);
            int r2=(c2==m)?Integer.MAX_VALUE:b.get(c2);

            if( l1<=r2 && l2<=r1){
                if( (n+m)%2==0){
                    double lv=Math.max(l1,l2);
                    double rv=Math.min(r2,r1);
                    return (lv+rv)/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }
            if(l1>r2) h=c1-1;
            else l=c1+1;
        }

        return 0.0;
    }
}
