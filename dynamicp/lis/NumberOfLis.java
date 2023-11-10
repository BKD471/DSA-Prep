package dynamicp.lis;
import java.util.Arrays;
public class NumberOfLis {
    public static int findNumberOfLIS(int []arr) {
        // Write your code here.
        int n=arr.length;
        int[] lis=new int[n];
        int[] cnt=new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(cnt,1);
        int mx=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && lis[j]+1>lis[i]){
                    lis[i]=1+lis[j];
                    cnt[i]=cnt[j];

                }else if(arr[j]<arr[i] && lis[j]+1==lis[i]){
                    cnt[i]+=cnt[j];
                }
            }
            mx=Math.max(mx, lis[i]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(lis[i]==mx) res+=cnt[i];
        }
        return res;
    }
}
