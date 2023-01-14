
class Solution26 {
    public static int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int grandMin=Integer.MAX_VALUE;

        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[m-1][i]=matrix[m-1][i];
        }

        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int south_east=Integer.MAX_VALUE,south_west=Integer.MAX_VALUE;
                int up=matrix[i][j]+dp[i+1][j];
                if(j<n-1) south_east=matrix[i][j]+dp[i+1][j+1];
                if(j>0) south_west=matrix[i][j]+dp[i+1][j-1];
                dp[i][j]=Math.min(up,Math.min(south_east,south_west));
            }
        }

        for(int i=0;i<n;i++){
            grandMin=Math.min(dp[0][i],grandMin);
        }

        return grandMin;
    }
}
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix={{2,1,3},
                {6,5,4},
                {7,8,9}};
        System.out.println(Solution26.minFallingPathSum(matrix));
    }
}
