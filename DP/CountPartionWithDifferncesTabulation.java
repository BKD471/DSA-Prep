public class CountPartionWithDifferncesTabulation {
    static final int MOD=(int)(Math.pow(10,9)+7);
    //to handle large value modulo by a large value
    public static int countPartitions(int n, int d, int[] arr) {
        int sum=0;
        for(int i=0;i<n;i++) sum+=arr[i];

        //Given TotalSum==s1+s2----eq 1
        //and s1-s2==d when s1>s2----eq2
        //from eq 1
        //s2=totsalsum-s1;
        //s2=totalSum-(d+s2);
        //2s2=totalSum+d;
        //s2=(totalsum+d)/2

        //so find no of subsets with target (totalSUm+d)/2


        if(sum-d<0) return 0;
        if( (sum-d)%2!=0) return 0;

        int target=(sum-d)/2;
        int[][] dp=new int[n][target+1];


        //case when we are at index 0, target=0 and arr[0]=0
        //that means 2 combos are possble since 0 doesnot change the target so we
        //can add or maynot add
        if(arr[0]==0) dp[0][0]=2;
            //arr[0]!=0 and target==0 then dont pick
        else dp[0][0]=1;

        //when arr[0]!=0 and target==arr[0] then pick it
        if(arr[0]!=0 && arr[0]<=target) dp[0][arr[0]]=1;


        for(int index=1;index<n;index++){
            for(int tar=0;tar<=target;tar++){
                int non_take=dp[index-1][tar];
                int take=0;
                if(tar>=arr[index])take=dp[index-1][tar-arr[index]];

                dp[index][tar]=(take+non_take)%MOD;
            }
        }

        return dp[n-1][target];
    }
}
