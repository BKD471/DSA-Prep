package dynamicp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class WordBreak {
    private int check(String s,int[] memo,Set<String> hash,int index){
        if(index>=s.length()) return 1;

        if(memo[index]!=-1) return memo[index];
        for(int i=index+1;i<=s.length();i++){
            String prefix=s.substring(index,i);
            if(hash.contains(prefix)){
                if(check(s,memo,hash,i)==1) return 1;
            }
        }
        memo[index]=0;
        return 0;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> hash=new HashSet<>(wordDict);
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return check(s,memo,hash,0)==1? true:false;
    }
}
