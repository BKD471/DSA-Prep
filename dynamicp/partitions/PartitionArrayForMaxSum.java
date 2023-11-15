package dynamicp.partitions;
import java.util.Arrays;
public class PartitionArrayForMaxSum {
    private static int solve(int[] arr,int i,int k,int[] memo){
        if(i>=arr.length) return 0;

        int maxEl=Integer.MIN_VALUE;
        int res=Integer.MIN_VALUE;
        if(memo[i]!=-1) return memo[i];
        for(int j=i;j<Math.min(arr.length,i+k);j++){
            int len=j-i+1;
            maxEl=Math.max(maxEl,arr[j]);
            int cost=(maxEl*len)+solve(arr, j+1, k,memo);
            res=Math.max(res,cost);
        }
        return memo[i]=res;
    }
    public static int maximumSubarray(int arr[], int k) {
        // Write your code here..
        int n=arr.length;
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        return solve(arr,0,k,memo);
    }
}
