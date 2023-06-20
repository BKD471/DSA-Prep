package revision.arrays;

public class MissingNumberLC268 {
    public int missingNumber(int[] nums){
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++) res^=nums[i];
        for(int i=0;i<=n;i++) res^=i;
        return res;
    }
}
