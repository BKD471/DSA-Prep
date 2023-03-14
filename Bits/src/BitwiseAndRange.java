public class BitwiseAndRange {
    public int rangeBitwiseAnd(int left, int right) {
        int res=0;

        while(left!=right){
            left>>=1;
            right>>=1;
            res++;
        }


        return right<<res;
    }
}
