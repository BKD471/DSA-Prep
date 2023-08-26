package revision.arrays;

class Rotate{
    public void swap(int[] nums,int l,int h){
        int t=nums[l];
        nums[l]=nums[h];
        nums[h]=t;
    }
    public void reverse(int[] nums,int l,int h){
        while(l<h){
            swap(nums,l,h);
            l++;
            h--;
        }
    }

    public int[] solve(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        if(k==0) return nums;

        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
        return nums;
    }
}