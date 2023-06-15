package BinarySearch;

public class FirstBad {
    public int firstBadVersion(int n) {
        int l=0,h=n,firstBad=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isBadVersion(mid)==true){
                firstBad=mid;
                h=mid-1;
            }else l=mid+1;
        }
        return firstBad;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
