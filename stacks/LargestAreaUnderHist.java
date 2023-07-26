package stacks;

import java.util.Stack;
import java.util.Arrays;
public class LargestAreaUnderHist {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[] leftSmaller=new int[n];
        int[] rightSmaller=new int[n];
        Arrays.fill(leftSmaller,0);
        Arrays.fill(rightSmaller,n-1);

        for(int i=0;i<n;i++){
            int v=heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=v) st.pop();

            if(!st.isEmpty()) leftSmaller[i]=st.peek()+1;
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            int v=heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=v) st.pop();

            if(!st.isEmpty()) rightSmaller[i]=st.peek()-1;
            st.push(i);
        }

        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int area=(rightSmaller[i]-leftSmaller[i]+1)*heights[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}
