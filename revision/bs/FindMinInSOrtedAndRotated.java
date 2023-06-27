package revision.bs;

public class FindMinInSOrtedAndRotated {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0,h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[h]) l=mid+1;
            else h=mid;
        }
        return nums[l];
    }
}
