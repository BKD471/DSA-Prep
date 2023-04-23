package org.example.Day15;

public class MaxSubstr {
    public static int solve(String A, int[] B, int c) {
        int n = A.length();
        int cnt = 0, right = 0, left = 0, mxLength = 0;
        while (right < n) {
            char t = A.charAt(right);
            if (B[t - 'a'] == 1) cnt++;

            while (cnt > c) {
                char leavingChar = A.charAt(left);
                if (B[leavingChar - 'a'] == 1) cnt--;
                left++;
            }
            mxLength = Math.max(mxLength, right - left + 1);
            right++;
        }
        return mxLength;

    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1};
        System.out.println(solve("vaboygpoeylfpbnp", a, 3));
    }
}
