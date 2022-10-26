public class ReversePairs {
    public int merge(int[] nums, int l, int m, int r) {
        int invc = 0;

        int n1 = (m - l + 1);
        int n2 = (r - m);

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = nums[l + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = nums[m + i + 1];
        }

        int i = 0, j = 0, k = l;
        while (i < n1) {
            // j=0;
            while (j < n2 && (long) L[i] > (long) 2 * R[j]) {
                invc += (n1 - i);
                j++;
            }
            i++;
        }


        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }

        while (i < n1) {
            nums[k++] = L[i++];
        }

        while (j < n2) {
            nums[k++] = R[j++];
        }

        return invc;
    }


    public int mergeSort(int[] nums, int l, int h) {

        int invc = 0;
        if (l < h) {
            int mid = l + (h - l) / 2;
            invc += mergeSort(nums, l, mid);
            invc += mergeSort(nums, mid + 1, h);
            invc += merge(nums, l, mid, h);

        }

        return invc;
    }

    public int reversePairs(int[] nums) {
        int l = 0, h = nums.length - 1;
        return mergeSort(nums, l, h);
    }
}
