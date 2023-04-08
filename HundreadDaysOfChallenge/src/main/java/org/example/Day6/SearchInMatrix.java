package org.example.Day6;

public class SearchInMatrix {
    public int binary_search(int [] n,int l,int h,int k){
        while(l<=h){
            int mid=l+(h-l)/2;
            if(n[mid]==k) return mid;
            if(n[mid]>k) h=mid-1;
            else l=mid+1;
        }
        return -1;
    }

    public int searchMatrix(int[][] nums, int k) {
        int m=nums.length,n=nums[0].length;
        int row=0;
        while(row<m){
            int v=nums[row][n-1];
            if(v<k) {
                row++;
                continue;
            }
            int idx=binary_search(nums[row],0,n-1,k);
            if(idx!=-1) return 1;
            row++;
        }
        return 0;
    }
}
