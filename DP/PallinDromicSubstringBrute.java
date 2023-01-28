import java.util.ArrayList;
import java.util.List;

public class PallinDromicSubstringBrute {

        public static boolean isPallin(String t){
            int h=t.length()-1, l=0;

            while(l<=h){
                if(t.charAt(h)!=t.charAt(l)) return false;
                h--;
                l++;
            }
            return true;
        }

        public static String longestPalindrome(String s) {
            int mxLen=Integer.MIN_VALUE;
            String op="";
            for(int i=0;i<s.length();i++){
                for(int j=i;j<s.length();j++){
                    String ts=s.substring(i,j+1);
                    if(isPallin(ts)){
                        int sz=ts.length();
                        if(sz>mxLen){
                            mxLen=sz;
                            op=ts;
                        }

                    }
                }
            }

            return op;
        }

        public static void main(String[] args) {
              String s="babad";
            System.out.println(PallinDromicSubstringBrute.longestPalindrome(s));
        }
}
