package BinarySearch;

public class SearchInMatrixLC74Best {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int l=0,h=m*n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target) return true;
            if(matrix[row][col]<target) l=mid+1;
            else h=mid-1;
        }
        return false;
    }
}
