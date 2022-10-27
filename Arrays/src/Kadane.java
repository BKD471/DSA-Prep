public class Kadane {

    public int largestSumContiguousSubarray(int[] arr){
        int meh=0,msf=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            meh+=arr[i];
            msf=Math.max(msf,meh);
            if(meh<0){
                meh=0;
            }
        }
        return msf;
    }
}
