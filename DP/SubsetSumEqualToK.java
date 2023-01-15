

import java.util.* ;
public class SubsetSumEqualToK {

    public static boolean comboSum(int arr[],int index,int target,int[][] memo){

        if(target==0){
            return true;
        }

        if(target<0) return false;

        if(memo[index][target]==0) return false;

        for(int i=index;i<arr.length;i++){

            if(comboSum(arr,i+1,target-arr[i],memo)==true) return true;
            if(comboSum(arr,i+1,target,memo)==true) return true;
        }

        memo[index][target]=0;
        return false;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){

        int[][] memo=new int[n+1][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return comboSum(arr,0,k,memo);
    }

    public static void main(String[] args) {
        int n=4,k=5;
        int[] arr={4,3,2,1};
        System.out.println(SubsetSumEqualToK.subsetSumToK(n,k,arr));
    }
}

