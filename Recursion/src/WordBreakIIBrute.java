import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution37{

    public static List<String> solve(String s,HashSet<String> set,int index){

        List<String> res=new ArrayList<>();
        if(index==s.length()){
            res.add("");
        }

        for(int i=index+1;i<=s.length();i++){
            String prefix=s.substring(index,i);
            if(set.contains(prefix)){
                List<String> suffix=solve(s,set,i);
                for(String t:suffix){
                    res.add(prefix+ (t.equals("")? "":" ")+t);
                }
            }
        }

        return res;
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs=new HashSet<>(wordDict);// convert to set for easiness in searching
        return solve(s,hs,0);
    }
}


public class WordBreakIIBrute {
    public static void main(String[] args) {
        String s="pineapplepenapple";
        List<String> serach=new ArrayList<>();
        serach.add("apple");serach.add("pen");serach.add("applepen");
        serach.add("pine");serach.add("pineapple");
        List<String> res=Solution37.wordBreak(s,serach);

        res.forEach(t->System.out.println(t));
    }
}
