import java.util.Arrays;
import java.util.Scanner;

class Frog {
    public static int distance(int[] steps, int k, int n, int[] memo) {

        if (n == 0) return 0;
        if (memo[n] != -1) return memo[n];

        int min_steps = Integer.MAX_VALUE;
        for (int jump = 1; jump <= k; jump++) {
            if (n - jump >= 0) {
                int dist = distance(steps, k, n - jump, memo) + Math.abs(steps[n] - steps[n - jump]);
                min_steps = Math.min(min_steps, dist);
            }
        }
        memo[n]=min_steps;
        return memo[n];
    }
}

public class FrogJumpKdistancesMemoized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt();
        int[] steps = new int[size];
        for (int i = 0; i < size; i++) {
            steps[i] = sc.nextInt();
        }
        int[] memo = new int[size];
        Arrays.fill(memo, -1);
        System.out.println(Frog.distance(steps, k, size - 1, memo));
    }
}
