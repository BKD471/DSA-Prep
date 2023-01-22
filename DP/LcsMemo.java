
import java.util.Arrays;
public class LcsMemo {
    public int lcs(String text1,String text2,int index1,int index2,int[][] memo){


        if(index1<0 || index2<0) return 0;


        if(memo[index1][index2]!=-1) return memo[index1][index2];

        if(text1.charAt(index1)==text2.charAt(index2)){
            memo[index1][index2]=1+lcs(text1,text2,index1-1,index2-1,memo);
            return memo[index1][index2];
        }
        else {
            memo[index1][index2]=Math.max(lcs(text1,text2,index1-1,index2,memo),lcs(text1,text2,index1,index2-1,memo));
            return memo[index1][index2];
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int p=text2.length();
        int[][] memo=new int[n][p];

        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
        return lcs(text1,text2,n-1,p-1,memo);
    }
}
