import java.util.HashMap;

public class SubarrayEqualsK {

    public int countzOfSubarrayEquals(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum - k)) {
                cnt += hashMap.get(sum - k);
            }
            if (hashMap.containsKey(sum)) {
                hashMap.put(sum, hashMap.get(sum) + 1);
            } else {
                hashMap.put(sum, 1);
            }
        }
        return cnt;
    }
}
