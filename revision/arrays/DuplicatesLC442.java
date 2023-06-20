package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesLC442 {

    public List<Integer> findDuplicates(int[] nums){
        int n=nums.length;
        int k=n+1;
        for(int i=0;i<n;i++){
            int index=(nums[i]%k)-1;
            nums[index]+=k;
        }

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]/k>=2) res.add(i+1);
        }
        return res;
    }
    public static void main(String[] args) {
        int n=21;
        System.out.println(n/9);
    }
}
