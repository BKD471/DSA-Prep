import java.util.Arrays;

public class EvaluateBooleanExp {
    static long mod=(long)(Math.pow(10,9)+7);
    public static long countExp(String exp,int l,int h,int isTrue,long[][][] memo){

        if(l==h){
            if(isTrue==1){
                if(exp.charAt(h)=='T') return 1;
                else return 0;
            }else{
                if(exp.charAt(h)=='F') return 1;
                else return 0;
            }
        }

        if(memo[l][h][isTrue]!=-1) return memo[l][h][isTrue];

        long count=0;
        for(int partition=l+1;partition<=h-1;partition+=2){
            long rt=countExp(exp, partition+1,h, 1,memo);
            long lt=countExp(exp, l, partition-1, 1,memo);
            long rf=countExp(exp, partition+1, h, 0,memo);
            long lf=countExp(exp, l, partition-1, 0,memo);
            if(exp.charAt(partition)=='|'){
                if(isTrue==1)count=(count+(lt*rt)%mod+(rt*lf)%mod+(rf*lt)%mod)%mod;
                else count=(count+(lf*rf)%mod)%mod;
            }else if(exp.charAt(partition)=='&'){
                if(isTrue==1) count=(count+(lt*rt)%mod)%mod;
                else count=(count+(lt*rf)%mod+(rt*lf)%mod+(rf*lf)%mod)%mod;
            }else{
                if(isTrue==1) count=(count+(lt*rf)%mod+(rt*lf)%mod)%mod;
                else count=(count+(rt*lt)%mod+(rf*lf)%mod)%mod;
            }
        }
        return memo[l][h][isTrue]=count%mod;
    }
    public static int evaluateExp(String exp) {
        // Write your code here.
        int n=exp.length();
        long[][][] memo=new long[n][n][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return (int)countExp(exp,0,n-1,1,memo);
    }
}
