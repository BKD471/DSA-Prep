import java.util.Arrays;

public class MinInsertionToPallin {
    public int lcs(String s,String ss,int index1,int index2,int[][] memo){

        if(index1<0 || index2<0) return 0;

        if(memo[index1][index2]!=-1) return memo[index1][index2];

        if(s.charAt(index1)==ss.charAt(index2)){
            memo[index1][index2]=1+lcs(s,ss,index1-1,index2-1,memo);
            return memo[index1][index2];
        }else{
            memo[index1][index2]=Math.max(lcs(s,ss,index1-1,index2,memo),lcs(s,ss,index1,index2-1,memo));
            return memo[index1][index2];
        }
    }
    public int minInsertions(String s) {

        //approach always keep the longest pallindromic subsq constant
        //because they are already pallindrome
        // pick the rest , reverse it and add
        //since we are adding the rest of string so it will be the answer


        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        String ss=sb.reverse().toString();

        int[][] memo=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);

        //lcs give sthe count of longest pallindrome subseq already present
        //total length-that count  will give the no of additions needed to be done
        return n-lcs(s,ss,n-1,n-1,memo);
    }
}
