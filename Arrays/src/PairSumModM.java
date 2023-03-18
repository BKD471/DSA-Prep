public class PairSumModM {
        public static final int LIMIT=(int)Math.pow(10,9)+7;
        public int solve(int[] A, int B) {
            int n=A.length;
            long[] hash=new long[B];

            long cnt=0;
            for(int i=0;i<n;i++){
                hash[A[i]%B]++;
            }

            long sumZero=hash[0];
            cnt=(cnt%LIMIT + ((sumZero*(sumZero-1))/2)%LIMIT)%LIMIT;


            if(B%2==0){
                long v=hash[B/2];
                cnt=(cnt%LIMIT+ ((v*(v-1))/2)%LIMIT)%LIMIT;
            }

            int i=1,j=B-1;
            while(i<j){
                long pairs=((hash[i]%LIMIT)*(hash[j]%LIMIT))%LIMIT;
                cnt=(cnt%LIMIT+pairs%LIMIT)%LIMIT;
                j--;
                i++;
            }
            return (int)cnt;
        }
}
