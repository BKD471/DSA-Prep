package BinarySearch;

public class SingleElementInSortedArrLC540 {
    public int oddOccurrence(int[] nums,int l,int h){
        int n=nums.length;
        while(l<=h){
            int mid=l+(h-l)/2;
            if((mid==0 || nums[mid]!=nums[mid-1]) && (mid==n-1 || nums[mid]!=nums[mid+1])) return nums[mid];
            if((((mid&1)==0) && (mid+1<n) && (nums[mid]==nums[mid+1]))  ||  (((mid&1)==1)  && (mid>0) && (nums[mid]==nums[mid-1]))) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }
    public int singleNonDuplicate(int[] nums) {
        return oddOccurrence(nums,0,nums.length-1);
    }
}
