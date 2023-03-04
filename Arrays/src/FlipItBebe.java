public class FlipItBebe {
    public int[] flip(String A) {
        int n=A.length();

        int cnt=0,mxCnt=-1,left=0,right=-1,leftTemp=0;
        for(int i=0;i<n;i++){

            if(A.charAt(i)=='0') cnt++;
            else cnt--;

            if(cnt>mxCnt){
                mxCnt=cnt;
                left=leftTemp;
                right=i;
            }

            if(cnt<0){
                leftTemp=i+1;
                cnt=0;
            }
        }

        if(right==-1) return new int[] {} ;
        return new int[] {left+1,right+1};
    }
}
