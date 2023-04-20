package org.example.Day13;

public class PermutationsOfAinB {
    public boolean compare(int[] A,int[] B){
        int m=A.length,n=B.length;
        for(int i=0;i<m;i++){
            if(A[i]!=B[i]) return false;
        }
        return true;
    }
    public int solve(String A, String B) {
        int m=A.length(),n=B.length();

        int[] freqA=new int[26];
        int[] freqB=new int[26];
        int cnt=0;
        for(int i=0;i<m;i++){
            freqA[A.charAt(i)-'a']++;
            freqB[B.charAt(i)-'a']++;
        }

        if(compare(freqA,freqB)) cnt++;

        int j=m;
        while(j<n){
            freqB[B.charAt(j-m)-'a']--;
            freqB[B.charAt(j)-'a']++;
            if(compare(freqA,freqB)) cnt++;
            j++;
        }
        return cnt;
    }
}
