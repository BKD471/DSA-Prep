package org.example.Day6;

public class RangeNum {
    public int first(int[] nums,int l,int h,int target){

        while(l<=h){
            int mid=l+(h-l)/2;
            if( (mid==0 || nums[mid-1]!=target) && nums[mid]==target) return mid;
            if(nums[mid]>=target) h=mid-1;
            else l=mid+1;
        }
        return -1;
    }

    public int last(int[] nums,int l,int h,int target){

        while(l<=h){
            int mid=l+(h-l)/2;
            if( (mid==nums.length-1 || nums[mid+1]!=target) && nums[mid]==target) return mid;
            if(nums[mid]<=target) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] nums, int k) {
        int n=nums.length;
        int idx1=first(nums,0,n-1,k);
        int idx2=last(nums,0,n-1,k);
        if(idx1==-1 || idx2==-1) return new int[] {-1,-1};
        return new int[]{idx1,idx2};
    }
}
