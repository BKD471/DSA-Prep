public class MCMTabulation {

    public static int matrixMul(int[] arr, int N) {
        int[][] dp = new int[N][N];

        for (int i = 1; i < N; i++) dp[i][i] = 0;


        for (int front = N - 1; front >= 1; front--) {
            for (int back = front + 1; back < N; back++) {
                int mnSteps = Integer.MAX_VALUE;
                for (int k = front; k <= back - 1; k++) {
                    int steps = arr[front - 1] * arr[k] * arr[back] + dp[front][k] + dp[k + 1][back];
                    mnSteps = Math.min(steps, mnSteps);
                }
                dp[front][back] = mnSteps;
            }
        }


        return dp[1][N - 1];
    }
}
