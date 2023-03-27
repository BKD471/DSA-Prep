

public class ModAiAjforAllij {
    private static final int LIMIT=(int)Math.pow(10,9)+7;
    public int solve(int[] A) {
        int n=A.length;
        long sum=0;

        int[] cnt=new int[1001];

        for(int i=0;i<n;i++) cnt[A[i]]++;

        for(int i=1;i<=1000;i++){
            for(int j=1;j<=1000;j++){
                if(i!=j && cnt[i]!=0 && cnt[j]!=0){
                    int v=(i%j)*cnt[i]*cnt[j];
                    sum=(sum%LIMIT+ v%LIMIT)%LIMIT;
                }
            }
        }
        return (int)sum;
    }
}