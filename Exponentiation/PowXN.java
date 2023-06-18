package Exponentiation;

public class PowXN {
    private  double calPowOptimal(double a, int b) {
        if (b == 0) return 1;
        double res = calPowOptimal(a,b/2);
        //even
        if ((b %2) == 0) return res*res;
        else return a*res*res;
    }
    public double myPow(double x, int n) {
        if(x==0) return 0;
        double res=calPowOptimal(x,Math.abs(n));
        return n<0? (1/res):res;
    }
}
