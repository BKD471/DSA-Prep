
class Solution21 {
    public static boolean isPallin(String res,int l,int n)
    {
        if(l>=n/2){
            return true;
        }

        if(res.charAt(l)!=res.charAt(n-l-1)) return false;
        else return isPallin(res,l+1,n);


    }

    public static boolean isPalindrome(String s) {
        String temp="";
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!=' ' && (( c>='a' && c<='z') || (c>='0' && c<='9'))) temp+=c;
        }

        return isPallin(temp,0,temp.length());

    }
}





public class PallinDrome {
    public static void main(String[] args) {
        System.out.println(Solution21.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
