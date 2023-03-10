public class SIngleNUmIII {
        public boolean checkSetBits(int n,int indx){
            while(indx>0){
                indx--;
                n=n>>1;
            }
            return ((n&1)>=1) ? true:false;
        }
        public int[] singleNumber(int[] nums) {
            int n=nums.length;
            int uniques=0;
            for(int i=0;i<n;i++) uniques^=nums[i];

            int indexFirstSetBit=-1;
            for(int i=0;i<=31;i++){
                if(checkSetBits(uniques,i)) indexFirstSetBit=i;
            }

            int unique_1=0,unique_2=0;
            for(int i=0;i<n;i++){
                if(checkSetBits(nums[i],indexFirstSetBit)){
                    unique_1^=nums[i];
                }else{
                    unique_2^=nums[i];
                }
            }
            return new int[] {unique_2,unique_1};

        }
}
