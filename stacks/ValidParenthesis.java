package stacks;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<n;i++){
            char opening=s.charAt(i);
            if(opening=='(' || opening=='{' || opening=='['){
                st.push(opening);
            }else{
                if(st.isEmpty()) return false;
                char closing=s.charAt(i);
                char open=st.peek();
                if((open=='(' && closing==')') || (open=='{' && closing=='}') || (open=='[' && closing==']')) st.pop();
                else return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}
