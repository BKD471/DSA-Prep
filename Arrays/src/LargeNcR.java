public class LargeNcR {
        public long factorial(long n,long p){
            long fact=1;
            for(int i=2;i<=n;i++){
                fact=( (fact%p)*(i%p))%p;
            }
            return fact;
        }
        public long calPower(long n,long e,long p){
            if(n==0) return 0;
            if(e==0) return 1;
            long res=(calPower(n,e/2,p)%p);
            res=((res%p)*(res%p))%p;
            return e%2==0? ((res+p)%p): (((n%p)*(res%p)+p)%p);
        }
        public int solve(int A, int B, int C) {
            long fact1=factorial(A,C);
            long fact2=factorial(A-B,C);
            long fact3=factorial(B,C);

            long power1=calPower(fact2,C-2,C);
            long power2=calPower(fact3,C-2,C);

            long res=(((fact1%C)*(power1%C))%C*(power2%C))%C;
            return (int) res;
        }
}

