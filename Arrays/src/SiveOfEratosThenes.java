public class SiveOfEratosThenes {
    public int countPrimes(int n) {
        if(n==0 || n==1 || n==2) return 0;
        boolean[] prime=new boolean[n];
        Arrays.fill(prime,true);

        prime[0]=false;prime[1]=false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(prime[i]==true){
                for(int j=i*i;j<n;j+=i){
                    prime[j]=false;
                }
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            if(prime[i]==true) cnt++;
        }

        return cnt;
    }
}
