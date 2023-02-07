import java.util.Arrays;

public class PartitionArrayForMaxSUm {
    public int partMax(int[] arr,int index,int k,int[] memo){

        if(index>=arr.length) return 0;
        if(memo[index]!=-1) return memo[index];

        int maxe=Integer.MIN_VALUE, maxSum=Integer.MIN_VALUE;
        for(int i=index;i<Math.min(arr.length,index+k);i++){
            maxe=Math.max(arr[i],maxe);
            int count=(i-index+1);
            int sum=maxe*count+partMax(arr,i+1,k,memo);
            maxSum=Math.max(sum,maxSum);
        }
        return memo[index]=maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        return partMax(arr,0,k,memo);
    }
}
