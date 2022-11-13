public class Rotate extends Utility{
    public int[] rotate(int[] nums,int k){
        int n= nums.length;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
        return nums;
    }
}
