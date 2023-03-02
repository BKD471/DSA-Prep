public class PlusOne {
    public int[] addOne(int[] A){
        int n=A.length,r=1,l0=0,index=0;
        while(l0<n && A[index]==0){
            l0++;
            index++;
        }

        String res="";
        for(int i=n-1;i>=l0;i--){
            int s=A[i]+r;
            int v=s%10;
            res=res+v;
            r=s/10;
        }

        if(r!=0) {
            res+=r;
        }


        int size=res.length();
        int[] op=new int[size];
        index=0;
        for(int i=size-1;i>=0;i--){
            op[index]=res.charAt(i)-'0';
            index++;
        }

        return op;
    }
}
