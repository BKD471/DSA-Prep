package BinarySearch;

public class DivisionWithPrecision {
    public static int bin_divison(int a,int b){
        if(a==0) return -99999;
        if(b==0) return 0;
        int divisor=Math.abs(a),dividend=Math.abs(b);
        int l=0,h=dividend,best=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(mid==(dividend/divisor)) return mid;
            if(mid<(dividend/divisor)) {
                best=mid;
                l=mid+1;
            }
            else h=mid-1;
        }
        if(a<0 || b<0) return -best;
        return best;
    }

    public static double bin_divison_with_precision(int a,int b,int precision){
        if(a==0) return -99999.0;
        if(b==0) return 0.0;
        int divisor=Math.abs(a),dividend=Math.abs(b);
        int l=0,h=dividend,best=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(mid==(dividend/divisor)) {
                best=mid;
                break;
            }
            if(mid<(dividend/divisor)) {
                best=mid;
                l=mid+1;
            }
            else h=mid-1;
        }


        double step=0.1;
        double res=best;
        for(int i=0;i<precision;i++){
            for(double k=res;k*divisor<=dividend;k+=step){
                res=k;
            }
            step/=10;
        }
        if(a<0 && b<0) return res;
        if(a<0 || b<0) return -res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(bin_divison(67767,569074700));
        System.out.println(bin_divison_with_precision(-7,-22,15));
        System.out.println(bin_divison_with_precision(67767,569074700,12));
    }
}
