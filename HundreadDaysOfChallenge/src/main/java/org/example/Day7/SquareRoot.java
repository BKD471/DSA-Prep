package org.example.Day7;

public class SquareRoot {
    public int sqrt(int A) {
        long l=0,h=(long)A;
        long ans=0;
        while(l<=h){
            long mid=l+(h-l)/2;
            if(mid*mid==(long)A) return (int)mid;
            if(mid*mid<A){
                ans=mid;
                l=mid+1;
            }
            else h=mid-1;
        }

        return (int)ans;
    }
}
