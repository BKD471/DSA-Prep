public class Sort012 extends Utility {
    public int[] sort(int[] arr, int n) {
        int l = 0, h = n - 1;
        int i = 0;
        while (i <= h) {
            if (arr[i] == 0) {
                swap(arr, l, i);
                l++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, h, i);
                h--;
            }
        }
        return arr;
    }


}
