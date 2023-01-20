public class TargetSumTabulation {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];

        // this problem is just like count subsets with given differnce
        //divide nos into + group and - group and chek no of them with differnce equals target or not
        //s1-s2=d
        //total=s1+s2
        //s2=total-s1
        //s2=total-(d+s2)
        //s2=(total-d)/2


        if((sum-target)<0) return 0;//target must not be negative
        if((sum-target)%2!=0) return 0;// target should always be a number
        target=(sum-target)/2;

        int[][] dp=new int[nums.length][target+1];


        if(nums[0]==0 ) dp[0][0]=2;
        else dp[0][0]=1;

        if(nums[0]!=0 && nums[0]<=target) dp[0][nums[0]]=1;

        for(int index=1;index<nums.length;index++){
            for(int targ=0;targ<=target;targ++){
                int pick=0;
                if( targ>=nums[index])  pick=dp[index-1][targ-nums[index]];
                int non_pick=dp[index-1][targ];

                dp[index][targ]=pick+non_pick;
            }
        }

        return dp[nums.length-1][target];
    }
}
