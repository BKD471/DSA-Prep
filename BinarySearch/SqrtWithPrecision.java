package BinarySearch;

public class SqrtWithPrecision {
    private  static final int precision=11;
    public static double mySqrt(int x) {
        int l=1,h=x;
        int best=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(mid==(x/mid)){
                best=mid;
                break;
            }
            if(mid<x/mid){
                best=mid;
                l=mid+1;
            }else h=mid-1;
        }

        double step=0.1;
        double res=best;
        for(int i=0;i<precision;i++){
            for(double j=res;j*j<=x;j+=step){
                res=j;
            }
            step/=10;
        }

        String f="%."+precision+"f";
        String op=String.format(f,res);
        return Double.parseDouble(op);
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(10));
    }
}
