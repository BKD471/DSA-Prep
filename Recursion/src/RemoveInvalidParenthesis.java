import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution39 {
    static int minCount=Integer.MAX_VALUE;
    //there will be duplicates solution so better to take a set
    static HashSet<String> res=new HashSet<>();
    public static void solve(String s,int lc,
                      int rc,int removalCount,int index,String temp){
        // if index reaches end of string that means
        //we have finsihed traversing the string
        if(index==s.length()){
            //check left ( brace count== right ) count then its valid
            // check the whther removalcount is equals to minCount so far
            //simply add it
            if(lc==rc && minCount==removalCount){
                res.add(temp);
                return;
                // else check we have found new minCount for removal ,
                //update the mincount, clear the arr because
                // we have found new minimum so they wont be part of
                //our final solution
            }else if(removalCount<minCount && lc==rc){
                minCount=removalCount;
                res.clear();
                res.add(temp);
                return;
            }
            return;
        }

        // when encountering a character ,allow it to pass throgh
        if(s.charAt(index)!='(' && s.charAt(index)!=')'){
            temp+=s.charAt(index);
            solve(s,lc,rc,removalCount,index+1,temp);
            temp=temp.substring(0,temp.length()-1);
        }else{
            //Stribver bhaiyas approach

            //Take it and proceed
            temp+=s.charAt(index);
            if(s.charAt(index)=='('){
                solve(s,lc+1,rc,removalCount,index+1,temp);
            }

            else if(s.charAt(index)==')' && lc>rc){ // take closing )
                //only if lc>rc coz it will be invalid otherwise
                solve(s,lc,rc+1,removalCount,index+1,temp);
            }

            //Dont take it & proceed
            temp=temp.substring(0,temp.length()-1);
            solve(s,lc,rc,removalCount+1,index+1,temp);
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        solve(s,0,0,0,0,"");
        return new ArrayList<>(res);
    }
}

public class RemoveInvalidParenthesis {

    public static void main(String[] args) {
        List<String> res=Solution39.removeInvalidParentheses("(a)())()");
        res.forEach(t-> System.out.println(t));
    }
}
