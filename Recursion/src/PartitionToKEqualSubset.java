

class Solution27 {

    public static boolean comboSum(int[] nums, boolean[] hash, int target, int sum, int index, int k) {

        if (k == 0) return true;

        if (target == sum) {
            return comboSum(nums, hash, target, 0, 0, k - 1);
        }

        if (target < sum) return false;


        for (int i = index; i < nums.length; i++) {
            if (!hash[i]) {
                hash[i] = true;
                if (comboSum(nums, hash, target, sum + nums[i], i + 1, k) == true) return true;
                // temp.remove(temp.size()-1);
                hash[i] = false;
            }
        }
        return false;

    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        boolean[] hash = new boolean[nums.length];
        int target = sum / k;
        if ((sum % k) != 0) return false;


        return comboSum(nums, hash, target, 0, 0, k);


    }
}


public class PartitionToKEqualSubset {
    public static void main(String[] args) {
        int[] nums={4,3,2,3,5,2,1};
        System.out.println(Solution27.canPartitionKSubsets(nums,4));
    }
}
