import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution35 {
    public static boolean solve(String s,HashSet<String> set,int index){

        if(index==s.length()){
            return true;
        }

        for(int i=index+1;i<=s.length();i++){
            String prefix=s.substring(index,i);
            if(set.contains(prefix)){
                if(solve(s,set,i)) return true;
            }
        }

        return false;
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs=new HashSet<>(wordDict);
        return solve(s,hs,0);
    }
}


public class WordBreakBrute {
    public static void main(String[] args) {
        String s="pineapplepenapple";
        List<String> serach=new ArrayList<>();
        serach.add("apple");serach.add("pen");serach.add("applepen");
        serach.add("pine");serach.add("pineapple");
        System.out.println(Solution35.wordBreak(s,serach));
    }
}
