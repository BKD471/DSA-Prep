public class LargestRectangleInHiostBrute {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int v=heights[i];
            int rsum=0;
            for(int j=i;j<n;j++){
                if(heights[j]>=v) rsum=v*(j-i+1);
                else break;
            }
            int lsum=0;
            for(int j=i;j>=0;j--){
                if(heights[j]>=v) lsum=v*(i-j+1);
                else break;
            }
            maxArea=Math.max(rsum+lsum-v,maxArea);
        }
        return maxArea;
    }
}
