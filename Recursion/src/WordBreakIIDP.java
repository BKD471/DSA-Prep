import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution38 {

    public static List<String> solve(String s,HashSet<String> set,int index,HashMap<Integer,List<String>> memo){

        List<String> res=new ArrayList<>();
        if(index==s.length()){
            res.add("");
        }

        if(memo.containsKey(index)) return memo.get(index);

        for(int i=index+1;i<=s.length();i++){
            String prefix=s.substring(index,i);
            if(set.contains(prefix)){
                List<String> suffix=solve(s,set,i,memo);
                for(String t:suffix){
                    res.add(prefix+ (t.equals("")? "":" ")+t);
                }
            }
        }

        memo.put(index,res);
        return res;
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs=new HashSet<>(wordDict);// convert to set for easiness in searching
        HashMap<Integer,List<String>> memo=new HashMap<>();
        return solve(s,hs,0,memo);
    }
}




public class WordBreakIIDP {
    public static void main(String[] args) {
        String s="pineapplepenapple";
        List<String> serach=new ArrayList<>();
        serach.add("apple");serach.add("pen");serach.add("applepen");
        serach.add("pine");serach.add("pineapple");
        List<String> res=Solution38.wordBreak(s,serach);

        res.forEach(t-> System.out.println(t));
    }
}
