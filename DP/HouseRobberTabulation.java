
class Solution9 {
    public static int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int take=nums[i];
            //Edge case ,if i=1 then (i-2) will be f(-1) which must return 0
            if(i>1) take+=dp[i-2];
            int non_take=dp[i-1];

            dp[i]=Math.max(take,non_take);
        }
        return dp[n-1];
    }
}

public class HouseRobberTabulation {
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(Solution9.rob(nums));
    }
}
