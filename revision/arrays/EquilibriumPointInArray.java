package revision.arrays;

public class EquilibriumPointInArray {
    public int solve(int[] A) {
        int n=A.length;
        int[] l=new int[n];
        int[] r=new int[n];

        l[0]=A[0];
        for(int i=1;i<n;i++) l[i]=l[i-1]+A[i];

        r[n-1]=A[n-1];
        for(int j=n-2;j>=0;j--) r[j]=r[j+1]+A[j];

        for(int i=0;i<n;i++){
            if(l[i]==r[i]) return i;
        }
        return -1;
    }
}
