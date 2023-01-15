public class PartitionEqualSubTabulation {
    public static boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];

        if(sum%2!=0) return false;

        int target=sum/2;

        boolean[][] dp=new boolean[n][target+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        if(target>=nums[0]) dp[0][nums[0]]=true;


        for(int index=1;index<n;index++){
            for(int tar=1;tar<=target;tar++){
                boolean not_take=dp[index-1][tar];
                boolean take=false;
                if(nums[index]<=tar) take=dp[index-1][tar-nums[index]];

                dp[index][tar]=take || not_take;
            }
        }

        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(PartitionEqualSubTabulation.canPartition(nums));
    }
}