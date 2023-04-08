package org.example.Day5;

public class FindPeak {
    public int solve(int[] A) {
        int n = A.length;
        int l = 0, h = n - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if ((mid == n - 1 || A[mid] >= A[mid + 1]) && (mid == 0 || A[mid] >= A[mid - 1]))
                return A[mid];
            if (A[mid] <= A[mid + 1]) l = mid + 1;
            else if (A[mid] <= A[mid - 1]) h = mid - 1;
        }
        return -1;
    }
}
