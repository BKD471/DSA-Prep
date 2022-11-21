public class RearrangePosAndNegLeetcode2149 extends Utility{

    public int[] rearrange(int[] nums){
        int n= nums.length;
        int[] res=new int[n];

        int idx=0,posIdx=0,negIdx=1;
        while(idx<n){
            if(nums[idx]>0){
                res[posIdx]=nums[idx];
                posIdx+=2;
            }else{
                res[negIdx]=nums[idx];
                negIdx+=2;
            }
            idx++;
        }
        return res;
    }
}
