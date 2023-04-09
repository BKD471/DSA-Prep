package org.example.Day7;

public class RotatedSortedArray {

    public int findK(int[] nums,int l,int h){
        int k=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[0]<=nums[mid]) l=mid+1;
            else {
                k=mid;
                h=mid-1;
            }
        }
        return k;
    }

    public int bin_search(int[] nums,int l,int h,int k){

        while(l<=h){
            int mid=l+(h-l)/2;

            if(nums[mid]==k) return mid;
            if(nums[mid]<k) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
        int n=A.length;
        int idx=findK(A,0,n-1);
        if(idx==0) return bin_search(A,0,n-1,B);
        if(B>=A[0])return bin_search(A,0,idx-1,B);
        else return bin_search(A,idx,n-1,B);
    }
}
