import java.util.Arrays;

public class CountPartitionWithGivenDifferencesMemo {
    static final int MOD=(int)(Math.pow(10,9)+7);
    //to handle large value additions
    public static int countSubset(int[] arr,int index,int target,int[][] memo){
        if(target<0) return 0;
        if(index==0){
            //case when we are at index 0, target=0 and arr[0]=0
            //that means 2 combos are possble since 0 doesnot change the target so we
            //can add or maynot add
            if(target==0 && arr[index]==0) return 2;

            //if arr[0] !=0 but either target becomes 0 or target equals to arr[0]
            //then only one is possible
            if(target==0 || arr[index]==target) return 1;
            //else

            return 0;
        }

        if(memo[index][target]!=-1) return memo[index][target];

        int take=0;
        take=countSubset(arr,index-1,target-arr[index],memo);
        int non_take=countSubset(arr,index-1,target,memo);

        memo[index][target]=(take+non_take)%MOD;
        return memo[index][target];
    }

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
        int[][] memo=new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);

        return countSubset(arr,n-1,target,memo);
    }
}
