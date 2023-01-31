import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public boolean compare(String t1,String t2){

        int m=t1.length();
        int n=t2.length();

        if(m-n!=1) return false;

        int i=0,j=0;
        while(i<m){
            if(j==n) break;
            if(t1.charAt(i)==t2.charAt(j)){
                i++;
                j++;
            }else i++;
        }
        //it means second string is exhausted and new string
        //has stiill one remaining character
        if(i+1==m) return true;

        if(i==m && j==n) return true;
        return false;

    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, Comparator.comparing(l->l.length()));


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (  compare(words[i],words[j]) && dp[i] < 1 + dp[j]) {
                    //System.out.println("egr");
                    dp[i] = 1 + dp[j];
                }
            }
        }

        int mx = -1;
        for (int i = 0; i < n; i++) {
            if (mx < dp[i]) {
                mx = dp[i];
            }
        }
        return mx;
    }
}
