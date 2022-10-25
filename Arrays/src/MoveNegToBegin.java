public class MoveNegToBegin extends Utility {
    public int[] moveIt(int[] arr, int n) {
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                swap(arr, l, i);
                l++;
            }
        }
        return arr;
    }


}
