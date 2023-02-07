public class pallinDromePartitioningIITabulation {
    public boolean isPallin(String t){
        int l=0,h=t.length()-1;
        while(l<=h){
            if(t.charAt(l)!=t.charAt(h)) return false;
            h--;
            l++;
        }
        return true;
    }

    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=0;

        for(int part=n-1;part>=0;part--){
            int minCount=(int)Math.pow(10,9);
            for(int start=part;start<n;start++){
                String st=s.substring(part,start+1);
                if(isPallin(st)){
                    int count=1+dp[start+1];
                    minCount=Math.min(count,minCount);
                }
            }
            dp[part]=minCount;
        }
        return dp[0]-1;
    }
}
