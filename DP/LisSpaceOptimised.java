public class LisSpaceOptimised {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

        int[] prev=new int[n+1];
        int[] curr=new int[n+1];

        for(int index=n-1;index>=0;index--){
            for(int prev_index=index-1;prev_index>=-1;prev_index--){
                int not_take=prev[prev_index+1];
                int take=0;
                if(prev_index==-1 || nums[index]>nums[prev_index]) take=1+prev[index+1];
                curr[prev_index+1]=Math.max(not_take,take);
            }
            prev=curr;
        }
        return curr[0];
    }
}
