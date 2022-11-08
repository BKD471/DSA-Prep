public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxe = 1;
        int mine = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                int t = maxe;
                maxe = mine;
                mine = t;
            }

            maxe = Math.max(nums[i] * maxe, nums[i]);
            mine = Math.min(nums[i] * mine, nums[i]);
            result = Math.max(maxe, result);
        }

        return result;
    }
}
