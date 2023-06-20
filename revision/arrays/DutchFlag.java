package revision.arrays;

import static revision.arrays.Util.swap;

public class DutchFlag {

    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0,h=n-1,j=0;
        while(j<=h){
            if(nums[j]==0){
                swap(nums,l,j);
                l++;
                j++;
            }else if(nums[j]==1) j++;
            else{
                swap(nums,j,h);
                h--;
            }
        }
    }
}
