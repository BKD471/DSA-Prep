package contest;

public class FirstWorldProblems {
    public int[] richieHasARichDad(int[] nums) {
        int n=nums.length;
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) mx=Math.max(mx,nums[i]);

        int[] freq=new int[mx+1];
        for(int i=0;i<n;i++) freq[nums[i]]++;

        int[] res=new int[n];
        int j=0;
        for(int i=0;i<=mx;i++){
            int k=freq[i];
            while(k>0){
                res[j++]=i;
                k--;
            }
        }
        return res;
    }
}
