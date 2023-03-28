import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    public void solve(int n,int open,int close,List<String> res,List<String> temp){
        if( close==open && close==n & open==n) {
            String t="";
            for(int i=0;i<temp.size();i++) t+=temp.get(i);
            res.add(t);
            return;
        }

        if(open<n){
            temp.add("(");
            solve(n,open+1,close,res,temp);
            temp.remove(temp.size()-1);
        }
        if(close<open){
            temp.add(")");
            solve(n,open,close+1,res,temp);
            temp.remove(temp.size()-1);
        }

    }
    public String[] generateParenthesis(int A) {
        List<String> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();

        solve(A,0,0,res,temp);
        String[] op=new String[res.size()];
        for(int i=0;i<res.size();i++) op[i]=res.get(i);
        return op;
    }
}
