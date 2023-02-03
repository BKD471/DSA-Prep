import java.util.Arrays;

public class MatrixChainMul {
    static int mnMul(int[] arr,int l,int h,int[][] memo){
        if(l==h) return 0;

        if(memo[l][h]!=-1) return memo[l][h];

        int mnSteps=Integer.MAX_VALUE;
        for(int k=l;k<=h-1;k++){

            int steps=arr[l-1]*arr[k]*arr[h]+mnMul(arr,l,k,memo)+mnMul(arr,k+1,h,memo);
            mnSteps=Math.min(steps,mnSteps);
        }
        return memo[l][h]=mnSteps;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] memo=new int[N][N];
        for(int i=0;i<N;i++) Arrays.fill(memo[i],-1);
        return mnMul(arr,1,N-1,memo);
    }
}
