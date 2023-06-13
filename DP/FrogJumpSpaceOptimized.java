package DP;

public class FrogJumpSpaceOptimized {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int curr=0,prev=0,prev2=0;
        int r=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int l=prev+Math.abs(heights[i]-heights[i-1]);
            if(i>1)    r=prev2+Math.abs(heights[i]-heights[i-2]);

            curr=Math.min(l,r);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] heights={10,20,60,50,60};
        System.out.println(frogJump(5,heights));
    }
}
