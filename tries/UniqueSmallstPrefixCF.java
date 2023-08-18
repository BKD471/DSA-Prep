package tries;

class Triess{
    Triess[] node;
    int count;
    Triess(){
        this.node=new Triess[26];
        this.count=0;
    }
}

public class UniqueSmallstPrefixCF {
        private void insert(Triess root,String key){
            int n=key.length();
            if(n==0) return;
            Triess curr=root;
            for(int i=0;i<n;i++){
                int index=key.charAt(i)-'a';
                if(curr.node[index]==null) curr.node[index]=new Triess();
                curr=curr.node[index];
                curr.count+=1;
            }
        }

        private String getWords(Triess root,String word){
            int n=word.length();
            if(n==0) return null;

            Triess curr=root;
            String r="";
            for(int i=0;i<n;i++){
                int index=word.charAt(i)-'a';
                if(curr.node[index]==null) return "";
                curr=curr.node[index];
                r+=word.charAt(i);
                if(curr.count==1) break;
            }
            return r;
        }

        private String[] createList(String[] words){
            int n=words.length;
            String[] res=new String[n];
            if(n==0) return res;

            Triess root=new Triess();
            for(int i=0;i<n;i++) insert(root,words[i]);
            for(int i=0;i<n;i++) res[i]=getWords(root,words[i]);
            return res;
        }

        public String[] prefix(String[] words) {
            return createList(words);
        }
}
