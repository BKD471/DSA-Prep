public class MaxXorPairRange {
    public int pair(int L,int R){
        int n=L^R;

        int pos=0;
        while(n>0){
            n=n>>1;
            pos++;
        }

        return (1<<pos)-1;
    }
}
