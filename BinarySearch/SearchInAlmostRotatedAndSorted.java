package BinarySearch;

import java.util.Arrays;

public class SearchInAlmostRotatedAndSorted {
    public static int search(int[] nums,int target){
        int n=nums.length;
        int l=0,h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target) return mid;
            if(mid-1>=0 && nums[mid-1]==target) return mid-1;
            if(mid<n-1 && nums[mid+1]==target) return mid+1;
            if(nums[mid]>target) h=mid-2;
            else l=mid+2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={10,3,40,20,50,80,70};
        System.out.println(search(arr,70));
    }
}
