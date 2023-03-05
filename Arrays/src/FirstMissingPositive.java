public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int n=A.length;
        for(int i=0;i<n;i++){
            if(A[i]<0) A[i]=n+2;
        }

        for(int i=0;i<n;i++){
            int index=Math.abs(A[i])-1;
            if(index>=0 && index<n && A[index]>0) A[index]*=-1;
        }

        for(int i=0;i<n;i++){
            if(A[i]>0) return i+1;
        }
        return n+1;
    }
}
