public class RowsWithMax1s {
    public int bin_search(int[] A){
        int l=0,h=A.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(A[mid]==1 && (mid==0 || A[mid-1]!=1)) return mid;
            if(A[mid]==0) l=mid+1;
            else h=mid-1;
        }
        return A.length;
    }
    public int solve(int[][] A) {
        int m=A.length;
        int index=-1,mxCount=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int cnt=m-bin_search(A[i]);
            if(mxCount<cnt){
                mxCount=cnt;
                index=i;
            }
        }

        return index;
    }
}
