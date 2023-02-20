public class MaxAvgSubArray {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double sum=0;
        for(int i=0;i<k;i++) sum+=nums[i];

        double max_sum=sum;
        int left=1,right=k;
        while(right<n){
            sum=(double)(sum-nums[left-1]+nums[right]);
            if(sum>max_sum){
                max_sum=sum;
            }
            left++;
            right++;
        }
        return max_sum/k;
    }
}
