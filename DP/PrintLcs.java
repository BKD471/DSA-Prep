public class PrintLcs {

    public static String printLcs(String s,String s2) {


        int n = s.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) dp[i][0] = 0;
        for (int j = 0; j < m; j++) dp[0][j] = 0;

        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (s.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2],
                            dp[index1][index2 - 1]);
                }
            }
        }

        String res="";
        int j=m;
        int i=n;
        while(i>0 && j>0){
               if(s.charAt(i-1)==s2.charAt(j-1)) {
                   res+=s.charAt(i-1);
                   i=i-1;
                   j=j-1;
               }
               else{
                   int up=dp[i-1][j];
                   int  left=dp[i][j-1];
                   if(up>left){
                       i=i-1;
                       j=j;
                   }else{
                       i=i;
                       j=j-1;
                   }
               }
        }
        StringBuilder sb=new StringBuilder(res);
        return  sb.reverse().toString();
    }

    public static void main(String[] args) {
//        String s="abcdef";
//        String s2="bjkdef";
        String s="abcdefgh";
        String s1="abercdefg";
        System.out.println(PrintLcs.printLcs(s,s1));
    }
}
