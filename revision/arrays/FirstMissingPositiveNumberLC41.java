package revision.arrays;

public class FirstMissingPositiveNumberLC41 {
    public int FirstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) nums[i] = n + 2;
        }

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < 0 || index >= n || nums[index] < 0) continue;
            nums[index] *= -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        return n + 1;
    }
}
