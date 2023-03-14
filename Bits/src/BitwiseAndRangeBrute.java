public class BitwiseAndRangeBrute {
        public boolean checkSetBits(int n,int index){
            while(index>0){
                index--;
                n=n>>1;
            }
            return ((n&1)==1) ? true:false;
        }
        public int rangeBitwiseAnd(int left, int right) {
            int res=0,cnt=(right-left+1);

            for(int i=0;i<=31;i++){
                int count=0;
                for(int j=left;j<=right;j++){
                    if(checkSetBits(j,i)) count++;
                    else break;
                }
                if(count==cnt) res=(res | 1<<i);
            }

            return res;
        }
}
