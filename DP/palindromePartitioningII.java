import java.util.Arrays;

public class palindromePartitioningII {
    public boolean isPallin(String t){
        int l=0,h=t.length()-1;
        while(l<=h){
            if(t.charAt(l)!=t.charAt(h)) return false;
            h--;
            l++;
        }
        return true;
    }

    public int pallinPart(String t,int l,int h,int[] memo){
        if(l>=t.length()) return 0;
        if(memo[l]!=-1) return memo[l];
        int minCount=(int)Math.pow(10,9);
        for(int start=l;start<=h;start++){
            String st=t.substring(l,start+1);
            if(isPallin(st)){
                int count=1+pallinPart(t,start+1,h,memo);
                minCount=Math.min(count,minCount);
            }

        }
        return memo[l]=minCount;
    }
    public int minCut(String s) {
        int n=s.length();
        int[] memo=new int[n];

        Arrays.fill(memo,-1);
        return pallinPart(s,0,n-1,memo)-1;
    }
}
