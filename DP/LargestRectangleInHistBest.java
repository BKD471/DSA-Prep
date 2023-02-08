import java.util.Stack;

public class LargestRectangleInHistBest {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<Integer>();
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){

            while(!st.empty() && (i==n || heights[st.peek()]>=heights[i])){
                int key=heights[st.peek()];
                st.pop();
                int width=0;
                if(st.empty()) width=i;
                else width=(i-st.peek()-1);
                maxArea=Math.max(maxArea,key*width);
            }
            st.push(i);
        }

        return maxArea;
    }
}
