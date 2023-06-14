package BinarySearch;

public class SearchIngridLC74 {
    public int binary_search(int[] nums,int l,int h,int target){
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int l=0,h=m-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(target<=matrix[mid][n-1]) {
                if(binary_search(matrix[mid],0,n-1,target)!=-1) return true;
                h=mid-1;
            }else l=mid+1;
        }
        return false;
    }
}
