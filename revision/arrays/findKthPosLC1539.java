package revision.arrays;

public class findKthPosLC1539 {
    public  int kthpos(int[] arr,int k) {
        int n = arr.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int count = (arr[mid] - (mid + 1));
            if (count >= k) h = mid - 1;
            else l = mid + 1;
        }
        if (h == -1) return k;
        return arr[h] + k - (arr[h] - (h + 1));
    }
}
