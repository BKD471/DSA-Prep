import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution36 {
    public static boolean solve(String s,HashSet<String> set,int index,HashMap<Integer,Boolean> memo){

        if(index==s.length()){
            return true;
        }

        if(memo.containsKey(index)) return memo.get(index);

        for(int i=index+1;i<=s.length();i++){
            String prefix=s.substring(index,i);
            if(set.contains(prefix)){
                if(solve(s,set,i,memo)){
                    memo.put(index,true);
                    return true;
                }
            }
        }


        memo.put(index,false);
        return false;
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs=new HashSet<>(wordDict);// convert to set for easiness in searching
        HashMap<Integer,Boolean> memo=new HashMap<>();
        return solve(s,hs,0,memo);
    }
}



public class WordBreakDP {
    public static void main(String[] args) {
        String s="pineapplepenapple";
        List<String> serach=new ArrayList<>();
        serach.add("apple");serach.add("pen");serach.add("applepen");
        serach.add("pine");serach.add("pineapple");
        System.out.println(Solution36.wordBreak(s,serach));
    }
}
