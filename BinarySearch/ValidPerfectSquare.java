package BinarySearch;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int l=0,h=num;
        while(l<=h){
            long mid=l+(h-l)/2;
            if(mid*mid==num) return true;
            if(mid*mid>num) h=(int)mid-1;
            else l=(int)mid+1;
        }
        return false;
    }
}
