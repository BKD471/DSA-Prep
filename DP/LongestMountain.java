import java.util.Arrays;

public class LongestMountain {
    public int[] lis(int startIndex,int endIndex,int[] nums){
        int n=nums.length;

        int[] dp=new int[n];
        Arrays.fill(dp,1);

        if(startIndex==0){
            //for front lis
            for(int current=startIndex;current<endIndex;current++){
                if(current>0 && nums[current]>nums[current-1] && 1+dp[current-1]>dp[current]){
                    dp[current]=dp[current-1]+1;
                }
            }
        }else{
            //for backlis
            for(int current=startIndex;current>=endIndex;current--){
                if(current<=n-2 && nums[current]>nums[current+1] && dp[current]<1+dp[current+1]){
                    dp[current]=dp[current+1]+1;
                }
            }
        }

        return dp;
    }
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int[] frontLis=new int[n];
        int backLis[]=new int[n];

        Arrays.fill(frontLis,1);
        Arrays.fill(backLis,1);


        int[] frontLisDp=lis(0,n,arr);
        int[] backLisDp=lis(n-1,0,arr);

        //frontLisDp[i]=1 or backLisDp[i]=1  means no increasing seq has been found till that index i
        //so if both are 1 i.e  not changed  means no mountain can be made in that area
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(frontLisDp[i]!=1 && backLisDp[i]!=1){
                mx=Math.max(frontLisDp[i]+backLisDp[i]-1,mx);
            }
        }

        return mx!=Integer.MIN_VALUE? mx:0;
    }
}
