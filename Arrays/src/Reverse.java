public class Reverse extends Utility {
    public int[] reverse(int[] arr, int n) {

        int l = 0, h = n - 1;
        while (l <= h) {
            swap(arr, l, h);
            l++;
            h--;
        }
        return arr;
    }


}
