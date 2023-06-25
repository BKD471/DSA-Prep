package stacks;

import java.util.Stack;

public class NextGreater {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> st=new Stack<>();
        int n=A.length;

        int[] res=new int[n];
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && A[st.peek()]>=A[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i]=-1;
            else res[i]=A[st.peek()];
            st.push(i);
        }
        return res;
    }
}
