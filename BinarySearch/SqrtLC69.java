package BinarySearch;

public class SqrtLC69 {
    public int mySqrt(int x) {
        int l=1,h=x,res=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(x/mid==mid) return mid;
            if(x/mid>mid){
                res=mid;
                l=mid+1;
            }
            else h=mid-1;
        }
        return res;
    }
}
