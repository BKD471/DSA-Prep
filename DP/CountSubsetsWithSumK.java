import java.util.Arrays;

public class CountSubsetsWithSumK {
    public static int countSum(int ind,int target,int[] num,int[][] memo){
         //this is when testcase [1,1,0] target=1
        //ans should be 4 but striver bhaiyas approach will give 2
        //to take accnt for individual 0 , process till the list ends i.e to index==-1
        //and check if target is 0 then 1 else 0
        if(ind==-1 && target==0) return 1;
        if(ind==-1)  return target==0? 1:0;

        if(memo[ind][target]!=-1) return memo[ind][target];

        int pick=0;
        if(num[ind]<=target) pick=countSum(ind-1,target-num[ind],num,memo);
        int non_pick=countSum(ind-1,target,num,memo);

        memo[ind][target]=pick+non_pick;
        return memo[ind][target];
    }
    public static int findWays(int num[], int tar) {
        int n=num.length;
        int[][] memo=new int[n][tar+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return countSum(n-1,tar,num,memo);
    }
}
