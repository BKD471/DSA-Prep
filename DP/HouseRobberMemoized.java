import java.util.Arrays;

class Solution8 {
    static int maximizeProfit(int[] nums,int[] memo,int n){

        if(n<0) return 0;
        if(n==0) return nums[0];
        if(memo[n]!=-1) return memo[n];
        int pick=nums[n]+maximizeProfit(nums,memo,n-2);
        int not_pick=maximizeProfit(nums,memo,n-1);
        memo[n]=Math.max(pick,not_pick);
        return memo[n];
    }

    public static int rob(int[] nums) {
        int n=nums.length;
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        return maximizeProfit(nums,memo,n-1);
    }
}

public class HouseRobberMemoized {
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(Solution8.rob(nums));
    }
}
