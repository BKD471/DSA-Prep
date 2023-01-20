import java.util.Arrays;

public class TargetSUm {
    public int countExpression(int[] nums,int index,int target,int[][] memo){
        if(index==0){
            if(nums[index]==0 && target==0) return 2;
            if(nums[index]==target ||  target==0) return 1;
            return 0;
        }

        if(memo[index][target]!=-1) return memo[index][target];

        int pick=0;
        if(target>=nums[index])pick=countExpression(nums,index-1,target-nums[index],memo);
        int non_pick=countExpression(nums,index-1,target,memo);

        memo[index][target]=pick+non_pick;
        return memo[index][target];
    }
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

        int[][] memo=new int[nums.length][target+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(memo[i],-1);
        }

        return countExpression(nums,nums.length-1,target,memo);
    }
}
