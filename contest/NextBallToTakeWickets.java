package contest;

public class NextBallToTakeWickets {
    public int[] wicketEconomies(int[] nums) {
        int n=nums.length;
        int mn=Integer.MAX_VALUE;
        boolean f=false;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]) f=true;
            if(f) mn=Math.min(mn,nums[i+1]);
        }

        int mx=Integer.MIN_VALUE;
        f=false;
        for(int i=n-1;i>0;i--){
            if(nums[i]<nums[i-1]) f=true;
            if(f) mx=Math.max(mx,nums[i-1]);
        }

        if(mx==Integer.MIN_VALUE || mn==Integer.MAX_VALUE) return new int[]{-1};


        for(int i=0;i<n;i++){
            if(nums[i]>mn){
                mn=i;
                break;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(nums[i]<mx){
                mx=i;
                break;
            }
        }

        return new int[]{mn,mx};
    }
}
