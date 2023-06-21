package revision.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> hash=new HashMap<>();

        for(int i=0;i<n;i++){
            int v=nums[i];
            if(hash.containsKey(target-v)){
                int indx=hash.get(target-v);
                return new int[]{indx,i};
            }else hash.put(v,i);
        }
        return new int[]{-1,-1};
    }
}
