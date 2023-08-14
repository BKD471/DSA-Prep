package tries;

import java.util.HashMap;

class Node{
    Node[] data=new Node[26];
    int count;
    boolean isEnd;
    Node(){
        for(int i=0;i<25;i++) data[i]=null;
        count=0;
        isEnd=false;
    }
}


public class SearchAllWordsWithSamePrefix {
    private void insert(Node root,String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.data[ch-'a']==null){
                Node t=new Node();
                curr.data[ch-'a']=t;
            }
            curr=curr.data[ch-'a'];
            curr.count++;
        }
        curr.isEnd=true;
    }

    private int query(Node root,String searchWord){
        Node curr=root;
        for(int i=0;i<searchWord.length();i++){
            char ch=searchWord.charAt(i);
            if(curr.data[ch-'a']==null) return 0;
            curr=curr.data[ch-'a'];
        }
        return curr.count;
    }

    public int prefixCount(String[] words, String pref) {
        int n=words.length;
        if(n==0) return 0;
        Node root=new Node();
        for(int i=0;i<n;i++){
            insert(root,words[i]);
        }
        return query(root,pref);
    }


    //sc O(n*m*26)


}

class TrieNode{
    HashMap<Character,TrieNode> hash=new HashMap<>();
    int count;
    boolean isEnd=false;
}
class SearchWordBetter{
    private void insert(TrieNode root,String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!curr.hash.containsKey(ch)){
                TrieNode t=new TrieNode();
                curr.hash.put(ch,t);
            }
            curr=curr.hash.get(ch);
            curr.count++;
        }
        curr.isEnd=true;
    }

    private int query(TrieNode root,String searchWord){
        TrieNode curr=root;
        for(int i=0;i<searchWord.length();i++){
            char ch=searchWord.charAt(i);
            if(!curr.hash.containsKey(ch)) return 0;
            curr=curr.hash.get(ch);
        }
        return curr.count;
    }

    public int prefixCountBetter(String[] words, String pref) {
        int n=words.length;
        if(n==0) return 0;
        TrieNode root=new TrieNode();
        for(int i=0;i<n;i++){
            insert(root,words[i]);
        }
        return query(root,pref);
    }
}
