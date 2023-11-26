package stacks;

import java.util.Stack;

public class PostfixEvaluation {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<String> st=new Stack<>();

        int res=0;
        for(int i=0;i<n;i++){
            String val=tokens[i];
            if(!val.equals("+") && !val.equals("*") && !val.equals("/") && !val.equals("-")){
                st.push(val);
            }else{
                switch(val){
                    case "+"->{
                        int a=Integer.parseInt(st.pop());
                        int b=Integer.parseInt(st.pop());
                        res=b+a;
                        st.push(String.valueOf(res));
                        break;
                    }
                    case "-"->{
                        int a=Integer.parseInt(st.pop());
                        int b=Integer.parseInt(st.pop());
                        res=b-a;
                        st.push(String.valueOf(res));
                        break;
                    }
                    case "*"->{
                        int a=Integer.parseInt(st.pop());
                        int b=Integer.parseInt(st.pop());
                        res=b*a;
                        st.push(String.valueOf(res));
                        break;
                    }
                    case "/" ->{
                        int a=Integer.parseInt(st.pop());
                        int b=Integer.parseInt(st.pop());
                        res=b/a;
                        st.push(String.valueOf(res));
                        break;
                    }
                }
            }
        }

        return Integer.parseInt(st.pop());
    }
}
