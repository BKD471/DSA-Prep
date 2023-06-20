package revision.arrays;

public class DuplicatesLC287 {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++){
            int indx=(Math.abs(nums[i])%n)-1;
            nums[indx]*=-1;
            if(nums[indx]>0) {
                res=indx+1;
                break;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]<0) nums[i]*=-1;
        }

        return res;
    }
}
