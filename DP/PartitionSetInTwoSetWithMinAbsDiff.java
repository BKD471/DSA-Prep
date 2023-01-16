public class PartitionSetInTwoSetWithMinAbsDiff {
        public static void subSetSum(int[] nums,int target,boolean[][] dp,int n){
            for(int i=0;i<n;i++) dp[i][0]=true;
            if(nums[0]<=target) dp[0][nums[0]]=true;

            for(int index=1;index<n;index++){
                for(int tar=1;tar<=target;tar++){
                    boolean not_take=dp[index-1][tar];
                    boolean take=false;
                    if(tar>=nums[index]) take=dp[index-1][tar-nums[index]];

                    dp[index][tar]=take || not_take;
                }
            }
        }
        public static int minSubsetSumDifference(int[] nums, int n) {
            // Write your code here.


            int totalSum=0;
            for(int i=0;i<n;i++){
                totalSum+=nums[i];
            }

            if(totalSum<=0) return 0;
            // target can be from 0 to totalSum;
            boolean[][] dp=new boolean[n][totalSum+1];
            subSetSum(nums,totalSum,dp,n);

            int grandMin=Integer.MAX_VALUE;
            for(int targetSum=0;targetSum<=totalSum;targetSum++){
                if(dp[n-1][targetSum]){
                    int s1=targetSum;
                    int s2=totalSum-targetSum;
                    grandMin=Math.min(grandMin,Math.abs(s1-s2));
                }
            }
            return grandMin;
        }

    public static void main(String[] args) {
        int[] nums={2,5,7,8,9};
        System.out.println(PartitionSetInTwoSetWithMinAbsDiff.minSubsetSumDifference(nums,5));
    }
}
