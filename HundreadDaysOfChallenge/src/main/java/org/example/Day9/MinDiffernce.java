package org.example.Day9;

import java.util.Arrays;
public class MinDiffernce {
    public int lower_bound(int[] nums, int key) {
        int l = 0, h = nums.length - 1, res = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= key) {
                res = nums[mid];
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return res;
    }

    public int upper_bound(int[] nums, int key) {
        int l = 0, h = nums.length - 1, res = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= key) {
                res = nums[mid];
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }


    public int solve(int m, int n, int[][] nums) {
        int mnDiff = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) Arrays.sort(nums[i]);

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int diff = Integer.MAX_VALUE;
                int value = lower_bound(nums[i + 1], nums[i][j]);
                if (value != -1) diff = Math.min(diff, Math.abs(nums[i][j] - value));

                value = upper_bound(nums[i + 1], nums[i][j]);
                if (value != -1) diff = Math.min(diff, Math.abs(nums[i][j] - value));
                if (diff == 0) return 0;
                mnDiff = Math.min(diff, mnDiff);
            }
        }

        return mnDiff;
    }
}

