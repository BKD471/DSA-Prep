import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLis {
    public static List<Integer> lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] tracker=new int[n];
        Arrays.fill(dp,1);

        for(int i=0;i<n;i++) tracker[i]=i;


        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && 1+dp[j]>dp[i]) {
                    dp[i]=1+dp[j];
                    tracker[i]=j;
                }
            }
        }

        int mx = -1;
        int mxIndex =-1;

        for(int i=0; i<n; i++){
            if(dp[i]> mx){
                mx = dp[i];
                mxIndex = i;
            }
        }

        ArrayList<Integer> temp=new ArrayList<Integer>();
        temp.add(nums[mxIndex]);

        while(tracker[mxIndex]!=mxIndex){
            mxIndex=tracker[mxIndex];
            temp.add(nums[mxIndex]);
        }

        Collections.reverse(temp);

        return temp;

    }

    public static void main(String[] args) {
         int[] num={10,9,2,5,3,7,101,18};
        System.out.println(PrintLis.lengthOfLIS(num));
    }
}
