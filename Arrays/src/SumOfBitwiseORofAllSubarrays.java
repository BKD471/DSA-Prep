public class SumOfBitwiseORofAllSubarrays {
    public int subarrayBitwiseORs(int[] arr) {
        int n=arr.length;
        int res=0;
        for(int bits=0;bits<=30;bits++){
            int index=n;
            for(int i=n-1;i>=0;i--){
                int v=(arr[i]>>bits)&1;
                if(v>=1) index=i;
                int pow=(int)Math.pow(2,bits);
                res+= (n-index)*pow;
            }
        }

        return res;
    }
}
