public class BawalProblem {
    public int bawali(int n) {
        if(n<=0) return 0;
        int res=0,currDigit=0,lowerDigit=0;
        String query=String.valueOf(n);
        int size=query.length();
        for(int i=0;i<size;i++){
            int key=query.charAt(i)-'0';
            if(key==0) continue;
            else if(key>1){
                int expo=size-i-1;
                currDigit=(int)Math.pow(10,expo);
                lowerDigit=key*((expo)*(currDigit/10));
                res+=currDigit+lowerDigit;
            }else{
                if(i==size-1) res+=1;
                else{
                    String temp="";
                    for(int j=i+1;j<size;j++){
                        temp+=query.charAt(j);
                    }
                    int expo=size-i-1;
                    currDigit=Integer.valueOf(temp)+1;
                    lowerDigit=(expo)*(int)(Math.pow(10,expo-1));
                    res+=currDigit+lowerDigit;
                }
            }
        }
        return res;
    }
}
