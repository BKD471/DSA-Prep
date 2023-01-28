public class PallinDromicSubstringOpt {

    public String longestPalindrome(String s) {

        int mxlen=Integer.MIN_VALUE;
        String op="";
        for(int i=0;i<s.length();i++){

            int l=i,r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;

                if(r-l+1>mxlen){
                    mxlen=r-l+1;
                    op=s.substring(l+1,r);
                }
            }

            l=i;r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                if(r-l+1>mxlen){
                    mxlen=r-l+1;
                    op=s.substring(l+1,r);
                }
            }

        }
        return op;
    }
}
