package BinarySearch;

public class FirstAndLastPosLC34 {
    public int firstIndex(int[] nums,int l,int h,int target){
        while(l<=h){
            int mid=l+(h-l)/2;
            if( nums[mid]==target && (mid==0 || nums[mid-1]!=target)) return mid;
            if(nums[mid]>=target) h=mid-1;
            else l=mid+1;
        }
        return -1;
    }

    public int lastIndex(int[] nums,int l,int h,int target){
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target && (mid==nums.length-1 || nums[mid+1]!=target)) return mid;
            if(nums[mid]<=target) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int first=firstIndex(nums,0,nums.length-1,target);
        int last=lastIndex(nums,0,nums.length-1,target);
        return new int[]{first,last};
    }
}
