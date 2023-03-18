public class InsaneNumbers {
    public static final int LIMIT1=(int)Math.pow(10,9)+7;
    public static final int LIMIT2=(int)Math.pow(10,9)+6;
    public long fact(int B){

        long ft=1;
        for(int i=1;i<=B;i++){
            ft=(i*(ft%LIMIT2))%LIMIT2;
        }
        return ft%LIMIT2;

    }

    public int calPow(int n,int e){
        if(n==0) return 0;
        if(e==0) return 1;

        long res=(calPow(n,e/2)%LIMIT1);
        res=((res%LIMIT1)*(res%LIMIT1))%LIMIT1;
        return e%2==0? (int)(res+LIMIT1)%LIMIT1:(int)(((n%LIMIT1)*(res%LIMIT1)+LIMIT1)%LIMIT1);

    }

    public int solve(int A, int B) {
        long f=fact(B);
        return calPow(A,(int)f);
    }
}
