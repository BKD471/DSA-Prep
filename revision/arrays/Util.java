package revision.arrays;

public class Util {
    public static void swap(int[] nums,int l,int h){
        int t=nums[l];
        nums[l]=nums[h];
        nums[h]=t;
    }
}
