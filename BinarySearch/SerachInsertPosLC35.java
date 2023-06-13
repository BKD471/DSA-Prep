package BinarySearch;

public class SerachInsertPosLC35 {
    public int lower_bound(int[] nums,int l,int h,int x){
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=x) h=mid;
            else l=mid+1;
        }
        if(nums[l]>=x) return l;
        if(nums[h]>=x) return h;
        return nums.length;
    }
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        return lower_bound(nums,0,n-1,target);
    }
}
