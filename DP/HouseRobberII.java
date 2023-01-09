import java.util.ArrayList;
import java.util.List;

class Solution10 {
    public static int rob(List<Integer> nums,int n){
        int[] dp=new int[n];
        dp[0]=nums.get(0);
        for(int i=1;i<n;i++){
            int take=nums.get(i);
            if(i>1) take+=dp[i-2];
            int non_take=dp[i-1];
            dp[i]=Math.max(take,non_take);
        }
        return dp[n-1];
    }

    public static int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        List<Integer> temp1=new ArrayList<Integer>();
        List<Integer> temp2=new ArrayList<Integer>();

        for(int i=0;i<n;i++){
            if(i!=0) temp1.add(nums[i]);
            if(i!=n-1) temp2.add(nums[i]);
        }
        return Math.max(rob(temp1,temp1.size()),rob(temp2,temp2.size()));
    }
}


public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums={2,3,4,5,6};
        System.out.println(Solution10.rob(nums));
    }
}
