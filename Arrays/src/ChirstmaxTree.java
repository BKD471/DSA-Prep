public class ChirstmaxTree {
    public static final int LIMIT = (int) Math.pow(10, 9);
    public int solve(int[] A, int[] B) {
        int n = A.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int key = A[i], l = LIMIT;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < key) {
                    l = Math.min(l, B[j]);
                }
            }

            int r = LIMIT;
            for (int k = i + 1; k < n; k++) {
                if (A[k] > key) {
                    r = Math.min(r, B[k]);
                }
            }
            res = Math.min(res, l + r + B[i]);
        }

        return res >= LIMIT ? -1 : res;
    }
}
