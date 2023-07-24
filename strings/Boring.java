package strings;

import java.util.HashSet;
import java.util.Set;

public class Boring {
    public int solve(String A) {
        int n=A.length();
        Set<Character> hash=new HashSet<>();
        for(int i=0;i<n;i++){
            int v=A.charAt(i);
            if((v&1)==0) hash.add(A.charAt(i));
        }

        for(int i=0;i<n;i++){
            int v=A.charAt(i);
            if((v&1)==1){
                char ch1=(char)(A.charAt(i)-1);
                char ch2=(char)(A.charAt(i)+1);
                if(hash.contains(ch1) && hash.contains(ch2)){
                    if(hash.size()>2) return 1;
                }
                else if(hash.contains(ch1) || hash.contains(ch2)){
                    if(hash.size()>1) return 1;
                }
                else{
                    if(hash.size()>=0) return 1;
                }
            }
        }
        return 0;
    }
}
