public class NextPermutation extends Utility{

    public void nextPermutation(int[] nums) {
        int idx=-1,n=nums.length;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                idx=i-1;
                break;
            }
        }
        if(idx==-1){
            reverse(nums,0,n-1);
            return;
        }

        int key=nums[idx];
        int minDiff=Integer.MAX_VALUE;
        int idex=-1;

        for(int i=idx+1;i<n;i++){
            int min=nums[i]-key;
            if(nums[i]>key && min<=minDiff){
                minDiff=min;
                idex=i;
            }
        }

        swap(nums,idex,idx);
        reverse(nums,idx+1,n-1);

    }
}
