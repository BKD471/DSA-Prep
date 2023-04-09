package org.example.Day7;

public class MaxStaircase {
    public int solve(int A) {

        long l=1,h=A,res=0;
        while(l<=h){
            long mid=l+(h-l)/2;

            long v=(mid*(mid+1))/2;
            if(v>A) h=mid-1;
            else {
                res=mid;
                l=mid+1;
            }
        }

        return (int)res;
    }
}
