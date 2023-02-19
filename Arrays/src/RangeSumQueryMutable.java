public class RangeSumQueryMutable {
    int[][] prefixSum;
    public RangeSumQueryMutable(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }

        this.prefixSum=matrix;

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum=this.prefixSum[row2][col2];
        int extra=( row1==0? 0:this.prefixSum[row1-1][col2]) + ( col1==0? 0: this.prefixSum[row2][col1-1])- ( (row1==0 || col1==0)? 0:this.prefixSum[row1-1][col1-1]);
        return totalSum-extra;
    }
}
