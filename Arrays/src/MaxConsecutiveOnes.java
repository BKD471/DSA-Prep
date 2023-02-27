public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length,cnt=k,len=0;
        int left=0,right=0;
        while(right<n){

            if(nums[right]==0) cnt--;
            if(cnt<0){
                if(nums[left]==0) cnt++;
                left++;
            }
            len=Math.max(len,right-left+1);
            right++;
        }

        return len;
    }
}
