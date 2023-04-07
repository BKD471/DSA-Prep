package org.example.Day5;

public class SortedInsertPosition {
    public int lower_bound(int[] nums,int l,int h,int k){
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]==k) return mid;
            if(nums[mid]>k) h=mid;
            else if(nums[mid]<k) l=mid+1;
        }
        return h;
    }
    public int searchInsert(int[] A, int B) {
        int n=A.length;
        if(A[n-1]<B) return n;
        return lower_bound(A,0,n-1,B);
    }
}
