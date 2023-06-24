package revision.bs;

public class SqrtLC69 {
    public int mySqrt(int x) {
        int l=1,h=x;
        int best=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(mid==x/mid) return mid;
            if(mid<x/mid){
                best=mid;
                l=mid+1;
            }else h=mid-1;
        }
        return best;
    }
}
