package strings;

public class StringMatcher {
    private static final long LIMIT=(long)(Math.pow(10,9)+7);
    public int solve(String A, String B) {
        int m=A.length();
        int n=B.length();

        long hashWindow=0,hashText=0,p=1;
        for(int i=0;i<n;i++){
            int w=B.charAt(i);
            int t=A.charAt(i);
            hashWindow=(hashWindow%LIMIT+(w*p)%LIMIT)%LIMIT;
            hashText=(hashText%LIMIT+(t*p)%LIMIT)%LIMIT;
            p=(p*31)%LIMIT;
        }

        int cnt=0;
        if(hashText==hashWindow) cnt++;


        int s=1,e=n;
        long x=1,y=p;
        while(e<m){
            int leaving=A.charAt(s-1);
            int incoming=A.charAt(e);

            long temp=(leaving*x)%LIMIT;
            long temp1=(incoming*y)%LIMIT;
            hashText=(hashText-temp+temp1+LIMIT)%LIMIT;
            x=(x*31)%LIMIT;
            y=(y*31)%LIMIT;
            hashWindow=(hashWindow*31)%LIMIT;
            if(hashText==hashWindow) cnt++;
            e++;
            s++;
        }
        return cnt;
    }
}
