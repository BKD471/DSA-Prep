import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] L = new int[n];
        int[] R = new int[n];

        Arrays.fill(L, 1);
        Arrays.fill(R, 1);


        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) L[i] = L[i - 1] + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) R[i] = R[i + 1] + 1;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += Math.max(L[i], R[i]);
        }

        return cnt;
    }

}
