package stacks;

import java.util.Stack;

public class RemoveAllAdjacent {
    public String removeDuplicates(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(st.isEmpty() || st.peek()!=ch) st.push(ch);
            else st.pop();
        }

        String res="";
        while(!st.isEmpty()) res+=st.pop();
        StringBuilder sb=new StringBuilder(res);
        return sb.reverse().toString();
    }
}
