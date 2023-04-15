package org.example.Day10;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithSUmK {
    public int[] solve(int[] nums, int k) {
        int n=nums.length;
        Map<Long,Integer> hash=new HashMap<>();

        long cum_sum=0;
        for(int i=0;i<n;i++){
            cum_sum+=nums[i];
            long key=cum_sum-k;
            if(key==0){
                int[] res=new int[i+1];
                for(int index=0;index<i+1;index++){
                    res[index]=nums[index];
                }
                return res;
            }
            if(hash.containsKey(key)){
                int j=hash.get(key);
                int[] res=new int[i-j];
                for(int idx=0;idx<(i-j);idx++){
                    res[idx]=nums[j+idx+1];
                }
                return res;
            }
            hash.put(cum_sum,i);
        }
        return new int[]{-1};
    }
}
