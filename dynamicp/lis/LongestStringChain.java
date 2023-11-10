package dynamicp.lis;

import java.util.Comparator;
import java.util.Arrays;
public class LongestStringChain {
    public static boolean compare(String s1,String s2){
        int m=s1.length(),n=s2.length();
        if(m!=n+1) return false;

        int i=0,j=0;
        while(i<s1.length()){
            if(j<n && s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return i==m && j==n;
    }
    public static int longestStrChain(String[] arr) {
        // Write your code here.
        int n=arr.length;
        Comparator<String> c=(a, b)->a.length()<b.length()?-1:a.length()>b.length()?1:0;
        Arrays.sort(arr,c);

        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int mx=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(compare(arr[i], arr[j]) && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            if(dp[i]>mx){
                mx=dp[i];
            }
        }
        return mx;
    }
}
