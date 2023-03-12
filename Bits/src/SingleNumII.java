public class SingleNumII {
        public boolean checkSetBits(int n,int index){
            while(index>0){
                index--;
                n=n>>1;
            }
            return ((n&1)==1)? true:false;
        }
        public int singleNumber(int[] nums) {
            int n=nums.length,res=0;
            for(int i=0;i<=31;i++){

                int cnt=0;
                for(int e:nums){
                    if(checkSetBits(e,i)) cnt++;
                }

                if(cnt%3>=1) res=(res|(1<<i));
            }

            return res;
        }
}
