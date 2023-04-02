package org.example.Day1;

public class LongestBalncedSubSTRING {
    //Intuition:
    //loop through and count the count of consecutive zeros and then ones
    //take the minumum of them  coz 00011  will give   0011 balanced
    //return twice of the max count so far coz  00011-->4  Min(000->3 & 11 ->2)-->2*2-->4
    public int findTheLongestBalancedSubstring(String s) {
        int n=s.length();
        int mxCnt=0;
        for(int i=0;i<n;i++){
            int cnt0=0,cnt1=0,j=i;
            while(j<n && s.charAt(j)=='0') {
                cnt0++;
                j++;
            }
            while(j<n && s.charAt(j)=='1'){
                cnt1++;
                j++;
            }
            mxCnt=Math.max(mxCnt,Math.min(cnt0,cnt1));
            i=j-1;
        }


        return mxCnt*2;
    }

}
