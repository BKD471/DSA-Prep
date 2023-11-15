package dynamicp.partitions;

public class PallinPartitionII {
    private boolean isPallin(String t,int l,int h){
        while(l<h){
            if(t.charAt(l)!=t.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
    private int solve(String s,int i,int[] memo){
        if(i>=s.length()) return 0;

        int min_cost=Integer.MAX_VALUE;
        if(memo[i]!=-1) return memo[i];
        for(int j=i;j<s.length();j++){
            if(isPallin(s,i,j)){
                int cost=1+solve(s,j+1,memo);
                memo[i]=min_cost=Math.min(min_cost,cost);
            }
        }
        return min_cost;
    }


    public int minCut(String A) {
        int[] memo=new int[A.length()];
        for(int i=0;i<A.length();i++) memo[i]=-1;
        return solve(A,0,memo)-1;
    }
}
