import java.util.ArrayList;

public class MultiDuplicates extends Utility {

    public ArrayList<Integer> duplicates(int[] arr, int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        int maxe = n + 1;
        for (int i = 0; i < n; i++) {
            int index = arr[i] % maxe;
            arr[index - 1] = arr[index - 1] + maxe;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 2 * maxe) res.add(i);
        }

        return res;
    }


}
