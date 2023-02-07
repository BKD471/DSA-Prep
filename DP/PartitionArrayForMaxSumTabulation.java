public class PartitionArrayForMaxSumTabulation {


    public int partArrayForMaxSum(int[] arr,int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        dp[n] = 0;


        for (int index = n - 1; index >= 0; index--) {

            int maxe = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE;
            for (int i = index; i < Math.min(arr.length, index + k); i++) {
                maxe = Math.max(arr[i], maxe);
                int count = (i - index + 1);
                int sum = maxe * count + dp[i + 1];
                maxSum = Math.max(sum, maxSum);
            }
            dp[index] = maxSum;
        }

        return dp[0];
    }

}
