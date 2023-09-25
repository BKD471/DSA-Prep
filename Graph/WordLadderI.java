import java.util.*;

class PairLadder{
    String word;
    int count;
    PairLadder(String word,int count){
        this.word=word;
        this.count=count;
    }
}

public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        if(beginWord.equals(endWord)) return 0;
        Set<String> hash = new HashSet<>(wordList);

        Queue<PairLadder> q=new LinkedList<>();
        q.offer(new PairLadder(beginWord,1));

        hash.remove(beginWord);
        while(!q.isEmpty()){
            PairLadder temp=q.poll();

            String wd=temp.word;
            int count=temp.count;

            if(wd.equals(endWord)) return count;

            for(int i=0;i<wd.length();i++){
                for(char c='a';c<='z';c++){
                    char[] chars=wd.toCharArray();
                    chars[i]=c;
                    String replacedWord=new String(chars);

                    if(hash.contains(replacedWord)){
                        q.offer(new PairLadder(replacedWord,count+1));
                        hash.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }
}
