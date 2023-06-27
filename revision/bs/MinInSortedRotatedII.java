package revision.bs;

public class MinInSortedRotatedII {
    public int findMinII(int[] nums) {
        int n=nums.length;
        int l=0,h=n-1,best=0;
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[h]) l=mid+1;
            else if(nums[mid]<nums[h]) h=mid;
            else h--;
        }
        return nums[l];
    }
}
