public class RearrangePosAndNeg extends Utility{

    public int[] rearrange(int[] nums){
        int n=nums.length;
        int posIndex=0,i=0;
        while(i<n){
            if(nums[i]<0){
                swap(nums,i,posIndex);
                posIndex++;
            }
            i++;
        }

       i=0;
       while(posIndex<n && i<n){
           if(i%2==0){
               swap(nums,i,posIndex);
               posIndex++;
           }
           i+=2;
       }

        return nums;
    }
}
