class Solution4 {
    public static int frogJump(int n, int heights[]) {
        // Write your code here..
        int[] dp=new int[n];
        dp[0]=0;
        int r=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int l=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            if(i>1)    r=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
            dp[i]=Math.min(l,r);
        }
        return dp[n-1];
    }

}
public class FrogJumpTabulation {
    public static void main(String[] args) {
        int[] heights={10,20,60,50,60};
        System.out.println(Solution4.frogJump(5,heights));
    }
}
