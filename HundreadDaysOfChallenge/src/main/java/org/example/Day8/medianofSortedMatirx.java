package org.example.Day8;

public class medianofSortedMatirx {
    public int bin_search(int[] nums,int key){
        int l=0,h=nums.length-1;
        int idx=-1;
        while(l<=h){
            int mid=l+(h-l)/2;

            if(nums[mid]<=key){
                idx=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }

        return idx;
    }

    public int findMedian(int[][] A) {
        int m=A.length,n=A[0].length;
        int l=0,h=(int)Math.pow(10,9);
        while(l<=h){
            int mid=l+(h-l)/2;
            int cnt=0;
            for(int i=0;i<m;i++){
                cnt+=bin_search(A[i],mid)+1;
            }

            if( cnt<=(m*n)/2) l=mid+1;
            else h=mid-1;
        }
        return l;
    }
}
