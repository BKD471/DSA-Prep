import java.util.Stack;

public class MaximalRectangle {
    public int maxArea(int hist[]){
        int s=hist.length;
        Stack<Integer>  st=new Stack<Integer>();
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<=s;i++){
            while(!st.empty() && (i==s || hist[st.peek()]>=hist[i])){
                int v=hist[st.peek()];
                st.pop();
                int width=0;
                if(st.empty()) width=i;
                else width=i-st.peek()-1;
                mx=Math.max(mx,v*width);
            }
            st.push(i);
        }
        return mx;
    }

    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[] histogram=new int[n];
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0') histogram[j]=0;
                else histogram[j]=histogram[j]+1;
            }
            mx=Math.max(mx,maxArea(histogram));
        }

        return mx;
    }
}
