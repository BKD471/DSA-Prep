public class KthS {
    public int symbol(int n,int k){
        if(n==1) return 0;
        int p=k/2+k%2;
        int parent=symbol(n-1,p);

        if(parent==1){
            return (k%2==1)? 1:0;
        }else{
            return  (k%2==1)? 0:1;
        }
    }
}
