package stacks;

import java.util.Stack;

public class NextSmaller {
    //case 1: < on left
    public int[] prevSmallerCase1(int[] A) {
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

    //case 2: <= on left
    public int[] prevSmallerCase2(int[] A) {
        Stack<Integer> st=new Stack<>();
        int n=A.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && A[st.peek()]>A[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i]=-1;
            else res[i]=A[st.peek()];
            st.push(i);
        }
        return res;
    }

    //case 3: > on left
    public int[] prevGreaterCase3(int[] A) {
        Stack<Integer> st=new Stack<>();
        int n=A.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && A[st.peek()]<=A[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i]=-1;
            else res[i]=A[st.peek()];
            st.push(i);
        }
        return res;
    }

    //case 4: <= on left
    public int[] prevGreaterCase4(int[] A) {
        Stack<Integer> st=new Stack<>();
        int n=A.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && A[st.peek()]<A[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i]=-1;
            else res[i]=A[st.peek()];
            st.push(i);
        }
        return res;
    }

    //case 5: < on right
    public int[] nextSmallerCase5(int[] A) {
        Stack<Integer> st=new Stack<>();
        int n=A.length;
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && A[st.peek()]>=A[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i]=n;
            else res[i]=A[st.peek()];
            st.push(i);
        }
        return res;
    }

    //case 6: <= on right
    public int[] nextSmallerCase6(int[] A) {
        Stack<Integer> st=new Stack<>();
        int n=A.length;
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && A[st.peek()]>A[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i]=n;
            else res[i]=A[st.peek()];
            st.push(i);
        }
        return res;
    }

    //case 7: > on right
    public int[] nextGreaterCase7(int[] A) {
        Stack<Integer> st=new Stack<>();
        int n=A.length;
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && A[st.peek()]<=A[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i]=n;
            else res[i]=A[st.peek()];
            st.push(i);
        }
        return res;
    }

    //case 8: >= on right
    public int[] nextGreaterCase8(int[] A) {
        Stack<Integer> st=new Stack<>();
        int n=A.length;
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && A[st.peek()]<A[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i]=n;
            else res[i]=A[st.peek()];
            st.push(i);
        }
        return res;
    }
}
