public class ArrayInMaxAndMin {


    public int[] rearrange(int[] nums){
        int n=nums.length;
        int l=0,h=n-1;
        int maxe=nums[n-1]+1;
        for(int i=0;i<n;i++){
            if(i%2==0) {
                nums[i]+=(nums[h]%maxe)*maxe;
                h--;
            }
            else{
                nums[i]+=(nums[l]%maxe)*maxe;
                l++;
            }
        }

        for(int i=0;i<n;i++){
            nums[i]/=maxe;
        }
        return nums;
    }
}
