import java.util.Stack;

public class LargestRectangleInHistBetter {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<Integer>();
        int nextSmallerRight[]=new int[n];
        int nextSmallerLeft[]=new int[n];

        for(int i=0;i<n;i++){
            while(!st.empty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(!st.empty() && heights[st.peek()]<heights[i]) nextSmallerLeft[i]=st.peek()+1;
            else nextSmallerLeft[i]=0;
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(!st.empty() && heights[st.peek()]<heights[i]) nextSmallerRight[i]=st.peek()-1;
            else nextSmallerRight[i]=n-1;
            st.push(i);
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
            int v=(nextSmallerRight[i]-nextSmallerLeft[i]+1)*heights[i];
            maxArea=Math.max(v,maxArea);
        }
        return maxArea;


    }
}
