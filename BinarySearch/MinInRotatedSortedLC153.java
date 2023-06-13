package BinarySearch;

public class MinInRotatedSortedLC153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1, k = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < nums[0]) {
                k = mid;
                h = mid - 1;
            } else l = mid + 1;
        }
        return nums[k];
    }
}
