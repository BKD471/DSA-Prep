package BinarySearch;

public class SearchInRotatedAndSortedLC33 {
    public int findK(int[] nums,int l,int h){
        int k=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]<nums[0]){
                k=mid;
                h=mid-1;
            }else l=mid+1;
        }
        return k;
    }
    public int bin_search(int[] nums,int l,int h,int target){
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n=nums.length;
        int k=findK(nums,0,n-1);
        if(k==0) return bin_search(nums,0,n-1,target);
        if(target<nums[0]){
            return bin_search(nums,k,n-1,target);
        }else{
            return bin_search(nums,0,k-1,target);
        }
    }
}
