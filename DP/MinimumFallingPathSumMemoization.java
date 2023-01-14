import java.util.Arrays;

class MinimumFallingPathSumMemoization {
    public static int lookUp(int[][] matrix,int row,int col,int m,int n,int[][] memo){
        if(col<0 || col>n-1) return Integer.MAX_VALUE;
        if(row>=m) return Integer.MAX_VALUE;
        if(row==m-1){
            return matrix[row][col];
        }

        if(memo[row][col]!=-1) return memo[row][col];
        int down=Integer.MAX_VALUE,south_west=Integer.MAX_VALUE,south_east=Integer.MAX_VALUE;


        //down
        if(row<m-1) down=matrix[row][col]+lookUp(matrix,row+1,col,m,n,memo);

        //south-west
        if(row<m-1 && col>0) south_west=matrix[row][col]+lookUp(matrix,row+1,col-1,m,n,memo);

        //south-east
        if(row<m-1 && col<n-1) south_east=matrix[row][col]+lookUp(matrix,row+1,col+1,m,n,memo);

        //System.out.println("Min:"+Math.min(down,Math.min(south_east,south_west)));
        memo[row][col]=Math.min(down,Math.min(south_east,south_west));
        return memo[row][col];

    }
    public static int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int grandMin=Integer.MAX_VALUE;

        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }


        for(int i=0;i<n;i++){
            int calculate=Math.min(lookUp(matrix,1,i-1,m,n,memo),
                    Math.min(lookUp(matrix,1,i,m,n,memo),lookUp(matrix,1,i+1,m,n,memo)));
            if(calculate==Integer.MAX_VALUE) calculate=0;
            int res=matrix[0][i]+calculate;
            grandMin=Math.min(res,grandMin);
        }
        return grandMin;
    }

    public static void main(String[] args) {
        int[][] matrix={
                {-80,-13,22},
                {83,94,-5},
                {73,-48,61}};
        System.out.println(MinimumFallingPathSumMemoization.minFallingPathSum(matrix));
    }
}
