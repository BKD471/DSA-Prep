public class MinSwapsToBringAll1TogetherCircular {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[] temp=new int[2*n];
        for(int i=0;i<2*n;i++) temp[i]=nums[i%n];

        int k=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) k++;
        }
        if(k==n) return 0;

        int bad=0;
        for(int i=0;i<k;i++){
            if(nums[i]!=1) bad++;
        }

        int min_swaps=bad,left=1,right=k;
        while(right<2*n){

            if(temp[left-1]!=1) bad--;
            if(temp[right]!=1) bad++;

            min_swaps=Math.min(min_swaps,bad);
            left++;
            right++;
        }
        return min_swaps;
    }
}
