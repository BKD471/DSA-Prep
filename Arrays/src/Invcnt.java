public class Invcnt {
    public static int merge(int[] A,int l,int mid,int h){
        int n1=(mid-l+1);
        int n2=(h-mid);

        int[] L=new int[n1];
        int[] R=new int[n2];
        int invc=0;


        for(int i=0;i<n1;i++){
            L[i]=A[i+l];
        }

        for(int i=0;i<n2;i++){
            R[i]=A[mid+i+1];
        }

        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]>R[j]){
                invc+=(n1-i);
                A[k++]=R[j++];
            }else{
                A[k++]=L[i++];
            }
        }

        while(i<n1) A[k++]=L[i++];
        while(j<n2) A[k++]=R[j++];
        return invc;
    }
    public static int invc(int[] A,int l,int h){
        int incnt=0;
        if(l<h){
            int mid=l+(h-l)/2;
            incnt+=invc(A,l,mid);
            incnt+=invc(A,mid+1,h);
            incnt+=merge(A,l,mid,h);
        }
        return incnt;
    }


    public static int solve(int[] A) {
        int n=A.length;
        return invc(A,0,n-1);
    }

    public static void main(String[] args) {
        int[] A={45,10,15,25,60};
        System.out.println(solve(A));
       // for(int i=0;i<5;i++) System.out.println(A[i]+" ");
    }
}
