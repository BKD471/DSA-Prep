//package tries;
//
//class TrieNodess{
//    public TrieNodess[] node;
//    public int count;
//    public boolean isEnd;
//    TrieNodess(){
//        this.node=new TrieNodess[26];
//        this.count=0;
//        this.isEnd=false;
//    }
//}
//
//public class SpellingChecker {
//    private void insert(TrieNodess root,String prefix){
//        TrieNodess curr=root;
//        int n=prefix.length();
//
//        for(int i=0;i<n;i++){
//            int index=prefix.charAt(i)-'a';
//            if(curr.node[index]==null){
//                TrieNodess temp=new TrieNode();
//                curr.node[index]=temp;
//                curr=curr.node[index];
//            } else{
//                curr=curr.node[index];
//            }
//            curr.count=curr.count+1;
//        }
//        curr.isEnd=true;
//    }
//
//    private TrieNodess createTrie(String[] words){
//        int m=words.length;
//        if(m==0) return null;
//
//        TrieNodess root=new TrieNode();
//        for(int i=0;i<m;i++) insert(root,words[i]);
//        return root;
//    }
//
//    private int checkPresence(TrieNodess root,String searchWord){
//        int m=searchWord.length();
//        if(m==0) return 0;
//
//        TrieNodess curr=root;
//        for(int i=0;i<m;i++){
//            int index=searchWord.charAt(i)-'a';
//            if(curr.node[index]==null) return 0;
//            curr=curr.node[index];
//        }
//        return curr.isEnd? 1:0;
//    }
//
//
//    public int[] solve(String[] vocab, String[] serachedWordList) {
//        int m=vocab.length;
//        int n=serachedWordList.length;
//        TrieNodess root=createTrie(vocab);
//
//        int[] res=new int[n];
//        for(int i=0;i<n;i++){
//            String word=serachedWordList[i];
//            res[i]=checkPresence(root,word);
//        }
//        return res;
//    }
//}
