package tries;


import java.util.List;

class TrieWord{
    char data;
    TrieWord[] node;
    boolean isLast;
    TrieWord(){
        this.node=new TrieWord[26];
        this.isLast=false;
    }
    TrieWord(char data){
        this.data=data;
        this.node=new TrieWord[26];
        this.isLast=false;
    }
}


public class WordBreak {
    private void insert(TrieWord root,String s){
        TrieWord curr=root;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(curr.node[index]==null){
                TrieWord t=new TrieWord(s.charAt(i));
                curr.node[index]=t;
            }
            curr=curr.node[index];
        }
        curr.isLast=true;
    }
    private boolean search(TrieWord root,String s){
        TrieWord curr=root;

        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(curr.node[index]==null) return false;
            curr=curr.node[index];
        }
        return curr.isLast;
    }

    private boolean breakIt(TrieWord root,String s){
        if(s.length()==0) return true;

        for(int i=1;i<=s.length();i++){
            if(search(root,s.substring(0,i)) && breakIt(root,s.substring(i,s.length()))) return true;
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=wordDict.size();
        TrieWord root=new TrieWord();
        for(int i=0;i<n;i++) insert(root,wordDict.get(i));

        TrieWord curr=root;
        return breakIt(curr,s);
    }
}
