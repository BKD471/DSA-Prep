package org.example.Day13;

public class MinWindow {
    // Online Java Compiler
    public static boolean compareIt(int[] A, int[] B) {
        int m = A.length, n = B.length;
        for (int i = 0; i < m; i++) {
            if ( A[i]<B[i]) return false;
        }
        return true;
    }


    public static String minWindow(String A, String B) {
        int n = A.length(), m = B.length();
        if(B.length()>A.length()) return "";

        int[] freqA = new int[128];
        int[] freqB = new int[128];
        for (int i = 0; i < m; i++) {
            freqA[A.charAt(i) - '0']++;
            freqB[B.charAt(i) - '0']++;
        }

        if (compareIt(freqA, freqB)) return A.substring(0,m);
        int j = m, i = 0, indxi = -1, indxj = -1;
        int mnLen = Integer.MAX_VALUE;

        //"ADOBECODEBANC"
        while (j < n) {
            freqA[A.charAt(j) - '0']++;
            while (compareIt(freqA, freqB)) {
                int len = j - i + 1;
                if (len < mnLen) {
                    indxi = i;
                    indxj = j;
                    mnLen = len;
                }
                freqA[A.charAt(i) - '0']--;
                i++;
            }
            j++;
        }
        if(indxi==-1 && indxj==-1) return "";
        return A.substring(indxi,indxj+1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ACBBECODEBANC", "ABC"));
    }

}
