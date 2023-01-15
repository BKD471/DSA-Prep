import java.util.Arrays;

public class PartitionEqualSub {
    public static boolean comboSum(int[] nums,int index,int target,int[][] memo){

        if(target==0) return true;
        if(target<0) return false;

        if(memo[index][target]!=-1) return false;
        for(int i=index;i<nums.length;i++){
            if(comboSum(nums,i+1,target-nums[i],memo)==true) return true;
            if(comboSum(nums,i+1,target,memo)==true) return true;
        }

        memo[index][target]=0;
        return false;
    }

    public static boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];

        if(sum%2!=0) return false;

        int target=sum/2;
        int[][] memo=new int[n+1][target+1];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
        return comboSum(nums,0,target,memo);
    }

    public static void main(String[] args) {
        int[] nums={100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100
                ,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        System.out.println(PartitionEqualSub.canPartition(nums));
    }
}
