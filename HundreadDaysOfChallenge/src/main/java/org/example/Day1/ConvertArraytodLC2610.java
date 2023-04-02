package org.example.Day1;

import java.util.ArrayList;
import java.util.List;

public class ConvertArraytodLC2610 {
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
