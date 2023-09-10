package dynamicp;

import java.util.ArrayList;
import java.util.Arrays;
public class HouseRobberII {
    private int solve(ArrayList<Integer> nums, int index, int[] memo){
        if(index>=nums.size()) return 0;
        if(memo[index]!=-1) return memo[index];
        int take1=nums.get(index)+solve(nums,index+2,memo);
        int take2=solve(nums,index+1,memo);
        memo[index]=Math.max(take1,take2);
        return memo[index];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        ArrayList<Integer> temp1=new ArrayList<>();
        ArrayList<Integer> temp2=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0) temp1.add(nums[i]);
            if(i!=nums.length-1) temp2.add(nums[i]);
        }

        int l=solve(temp1,0,memo);
        Arrays.fill(memo,-1);
        int r=solve(temp2,0,memo);
        return Math.max( l,r);
    }
}
