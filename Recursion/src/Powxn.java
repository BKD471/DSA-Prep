class Solution20 {
    public static double solve(double x,int n){
        if(n==0) return 1;
        double res=solve(x,n/2);
        res=res*res;
        return n%2==0? res:x*res;
    }

    public static double myPow(double x, int n) {
        if(x==0) return 0;
        double res=solve(x,Math.abs(n));
        return n<0? (1/res):res;
    }
}

public class Powxn {
    public static void main(String[] args) {
        System.out.println(Solution20.myPow(2.5,10));
    }
}

//TC O(logn)