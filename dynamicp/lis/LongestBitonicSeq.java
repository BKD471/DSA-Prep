package dynamicp.lis;
import java.util.Arrays;
public class LongestBitonicSeq {
    public static int longestBitonicSequence(int[] nums, int n) {
        // Write your code here.
        int[] left=new int[n];
        int[] right=new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && 1+left[j]>left[i]){
                    left[i]=1+left[j];
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j] && 1+right[j]>right[i]){
                    right[i]=1+right[j];
                }
            }
        }


        int mx=-1;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,left[i]+right[i]-1);
        }
        return mx;
    }
}
