package org.example.Day1;

import java.util.ArrayList;
import java.util.List;

public class ConvertArraytodLC2610 {
    //Intuition:
    // hierarchy depends on frequency of  array elements
    //take a hash and count the frequency...since the range is 200 so take a array of size 200
    //the highest freq count will determine the final array size
    //just loop through and for every frequency count add the lements into final set
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        int[] hash=new int[202];
        for(int i=0;i<n;i++) {
            hash[nums[i]]++;
        }
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<=201;i++){
            mx=Math.max(mx,hash[nums[i]]);
        }

        int idx=1;
        while(idx<mx+1){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<=201;i++){
                if(hash[i]>=idx) temp.add(i);
            }

            if(temp.size()>0) res.add(temp);
            idx++;
        }
        return res;
    }
}
