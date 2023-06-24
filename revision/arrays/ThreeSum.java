package revision.arrays;

import java.util.ArrayList;
import java.util.List;
import  java.util.Arrays;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<n-2;i++){
            int l=i+1;
            int h=n-1;
            while(l<h){
                int v=nums[i]+nums[l]+nums[h];
                if(v==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[h]);
                    res.add(temp);

                    int lv=nums[l];
                    while(l<h && nums[l]==lv) l++;

                    int rv=nums[h];
                    while(h>l && nums[h]==rv) h--;
                }
                else if(v<0) l++;
                else h--;
            }

            while(i<n-1 && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
}
