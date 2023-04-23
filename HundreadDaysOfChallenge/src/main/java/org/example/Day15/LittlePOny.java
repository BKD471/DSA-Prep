package org.example.Day15;

import java.util.Arrays;

public class LittlePOny {
    public static int binSearch(int[] nums,int key){
        int l=0,h=nums.length-1;
        if(nums[h]<=key) return h+1;
        if(nums[l]>key) return 0;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]<=key){
                ans=mid;
                l=mid+1;
            }else h=mid-1;
        }

        return ans+1;
    }

    public static int[] solve(int[] A, int[] B) {
        int n=A.length,m=B.length;
        for(int i=1;i<n;i++){
            A[i]+=A[i-1];
        }

        int[] res=new int[m];
        for(int i=0;i<m;i++){
            int r=binSearch(A,B[i]);
            res[i]=r;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] prices={23,36,58,59};
        int[] products={3,207,62,654,939,680,760};

       int[] res=solve(prices,products);
       Arrays.stream(res).forEach( i-> System.out.println(i));
    }
}
