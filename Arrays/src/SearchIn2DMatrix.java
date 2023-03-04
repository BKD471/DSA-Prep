public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;

        int i=0,j=n-1,minV=Integer.MAX_VALUE;
        while(i<m && j>=0){

            int value=matrix[i][j];
            if(value==target){
                return true;
            }else if(value<target) i++;
            else j--;
        }

        return false;
    }
}
