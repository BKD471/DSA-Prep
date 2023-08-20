package heaps;

public class KthLargest {
    private void swap(int[] nums, int l, int h) {
        int t = nums[l];
        nums[l] = nums[h];
        nums[h] = t;
    }

    private void maxHeapify(int[] nums, int root, int n) {
        int l = (2 * root) + 1;
        int r = (2 * root) + 2;
        int largest = root;
        if (l < n && nums[l] > nums[root]) largest = l;
        if (r < n && nums[r] > nums[largest]) largest = r;
        if (largest != root) {
            swap(nums, largest, root);
            maxHeapify(nums, largest, n);
        }
    }

    private void buildHeap(int[] nums, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, n);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return -1;
        buildHeap(nums, n);
        int res = -1;
        while (k-- > 0) {
            res = nums[0];
            swap(nums, 0, n - 1);
            n--;
            maxHeapify(nums, 0, n);
        }
        return res;
    }

    //tc n+ klogn
}
class KthLargestBetter{
    private void swap(int[] nums,int l,int h){
        int t=nums[l];
        nums[l]=nums[h];
        nums[h]=t;
    }
    private void minHeapify(int[] nums,int root,int n){
        int l=(2*root)+1;
        int r=(2*root)+2;
        int smallest=root;
        if(l<n && nums[l]<nums[root]) smallest=l;
        if(r<n && nums[r]<nums[smallest]) smallest=r;
        if(smallest!=root){
            swap(nums,smallest,root);
            minHeapify(nums,smallest,n);
        }
    }

    private void buildHeap(int[] nums,int n){
        for(int i=n/2-1;i>=0;i--){
            minHeapify(nums,i,n);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        if(k>n) return -1;
        buildHeap(nums,k);

        for(int i=k;i<n;i++){
            if(nums[i]>nums[0]){
                nums[0]=nums[i];
                minHeapify(nums,0,k);
            }
        }
        return nums[0];
        // k+(n-k)logk
    }
}