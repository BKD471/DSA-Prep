public class MaxAndPair {
        public boolean checkSetBits(int n,int i){
            while(i>0){
                n=n>>1;
                i--;
            }
            return ((n&1)>=1)? true:false;
        }
        public int solve(int[] A) {
            int n=A.length,res=0;
            for(int index=30;index>=0;index--){
                int cnt=0;
                for(int i=0;i<n;i++){
                    if(checkSetBits(A[i],index)) cnt++;
                    if(cnt>=2) break;
                }
                if(cnt>=2){
                    for(int i=0;i<n;i++){
                        if(!checkSetBits(A[i],index)) A[i]=0;
                    }
                    res=(res | 1<<index);

                }
            }
            return res;
        }
}
