package dynamicp;
import java.util.Arrays;
public class HouseRobber {
    private int solve(int[] nums,int index,int[] memo){
        if(index>=nums.length) return 0;
        if(memo[index]!=-1) return memo[index];
        int take1=nums[index]+solve(nums,index+2,memo);
        int take2=solve(nums,index+1,memo);
        memo[index]=Math.max(take1,take2);
        return memo[index];
    }
    public int rob(int[] nums) {
        int[] memo=new int[nums.length+1];
        Arrays.fill(memo,-1);
        return solve(nums,0,memo);
    }
}
