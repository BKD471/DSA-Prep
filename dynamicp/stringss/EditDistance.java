package dynamicp.stringss;
import java.util.Arrays;
public class EditDistance {
    private static int solve(String s1,String s2,int i,int j,int[][] memo){
        if(i<0) return 1+j; //add
        if(j<0) return 1+i;  //remove

        if(memo[i][j]!=-1) return memo[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j]=solve(s1,s2,i-1,j-1,memo);
            return memo[i][j];
        }else{

            int insert=1+solve(s1,s2,i,j-1,memo);
            int remove=1+solve(s1,s2,i-1,j,memo);
            int replace=1+solve(s1,s2,i-1,j-1,memo);
            memo[i][j]=Math.min(insert,Math.min(remove,replace));
            return memo[i][j];
        }
    }
    public static int editDistance(String str1, String str2) {
        //Your code goes here
        int m=str1.length(),n=str2.length();
        int[][] memo=new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(memo[i],-1);
        return solve(str1,str2,m-1,n-1,memo);
    }
}
