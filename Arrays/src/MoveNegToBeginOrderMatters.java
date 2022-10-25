public class MoveNegToBeginOrderMatters extends Utility {


    public void reverse(int[] arr, int l, int h) {

        while (l <= h) {
            swap(arr, l, h);
            l++;
            h--;
        }

    }

    public void merge(int[] arr, int l, int m, int h) {

        int i = l, j = m + 1;
        while (i <= m && arr[i] < 0) {
            i++;
        }

        while (j <= h && arr[j] < 0) {
            j++;
        }

        reverse(arr, i, m);
        reverse(arr, m + 1, j - 1);
        reverse(arr, i, j - 1);
    }

    public void mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = l + ((h - l) / 2);
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);
            merge(arr, l, mid, h);
        }
    }

    public int[] reArrangePosNeg(int[] arr, int n) {
        int l = 0, h = n - 1;
        mergeSort(arr, l, h);
        return arr;
    }
}
