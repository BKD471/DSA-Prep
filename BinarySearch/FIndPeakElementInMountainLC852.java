package BinarySearch;

public class FIndPeakElementInMountainLC852 {
    public int peakIndexInMountainArray(int[] nums) {
        int n=nums.length;
        int l=0,h=n-1;
        int best=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if((mid==n-1 || nums[mid]>nums[mid+1]) && (mid==0 || nums[mid]>nums[mid-1])) return mid;
            if(nums[mid]>nums[mid+1]) h=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}
