public class JosephusProblem {
    public int solve(int A) {
        int pow=0;
        for(int i=1;i<A;i++){

            if(A< (1<<i)) break;
            else pow=(1<<i);
        }

        int nearestPow=A-pow;
        return 1+2*nearestPow;
    }
}
