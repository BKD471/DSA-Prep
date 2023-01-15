public class SubSetSumEqualsToKTabulation {
    public static boolean subsetSumToK(int n, int k, int arr[]){

        boolean[][] dp=new boolean[n][k+1];
        //dp[index][target]
        //base case
        for(int i=0;i<n;i++) dp[i][0]=true; //for target==0 it should always be true
        if(arr[0]<=k) dp[0][arr[0]]=true;   //for index==0 && target==arr[0] it should be true always

        for(int index=1;index<n;index++){
            for(int target=1;target<=k;target++){
                boolean not_take=dp[index-1][target];

                boolean take=false;
                if(target>=arr[index]) take=dp[index-1][target-arr[index]];
                dp[index][target]=take || not_take;
            }
        }

        return dp[n-1][k];
    }

    public static void main(String[] args) {
        int n=4,k=5;
        int[] nums={4,3,2,1};
        System.out.println(SubSetSumEqualsToKTabulation.subsetSumToK(n,k,nums));
    }
}
