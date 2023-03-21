public class NumOfZeroFilledSubLC2348 {
        public long zeroFilledSubarray(int[] nums) {
            int n=nums.length;
            long res=0,cnt=0;
            for(int i=0;i<n;i++){
                if(nums[i]==0) cnt++;
                else{
                    if(cnt>0){
                        long v=(cnt*(cnt+1))/2;
                        res+=v;
                    }
                    cnt=0;
                }
            }
            long v=(cnt*(cnt+1))/2;
            if(cnt>0) res+=v;
            return res;
        }
}
