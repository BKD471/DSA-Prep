package dynamicp;

import java.util.*;

public class WordBreakII {
    private List<String> breakItBebe(String s,int index,Set<String> hash,Map<Integer,List<String>> mp){
        List<String> res=new ArrayList<>();
        if(index==s.length()){
            res.add("");
        }

        if(mp.containsKey(index)) return mp.get(index);
        for(int i=index+1;i<=s.length();i++){
            String prefix=s.substring(index,i);
            if(hash.contains(prefix)){
                List<String> temp=breakItBebe(s,i,hash,mp);
                for(String t:temp){
                    String tt=prefix+(t.equals("")? "":" ")+t;
                    res.add(tt);
                }
            }
        }

        mp.put(index,res);
        return res;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> hash=new HashSet<>(wordDict);
        Map<Integer,List<String>> mp=new HashMap<>();
        return breakItBebe(s,0,hash,mp);
    }
}
