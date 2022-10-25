public class CountInversion extends Utility {
    public int merge(int[] arr, int l, int m, int h) {
        int invc=0;

        int n1=(m-l+1);
        int n2=(h-m);

        int[] L=new int[n1];
        int[] R=new int[n2];

        for(int i=0;i<n1;i++){
            L[i]=arr[l+i];
        }

        for(int i=0;i<n2;i++){
            R[i]=arr[m+i+1];
        }

        int i=0,j=0,k=l;

        while(i<n1 && j<n2){

            if(L[i]<=R[j]){
                arr[k++]=L[i++];
            }else{
                invc+=(n1-i);
                arr[k++]=R[j++];
            }
        }

        while(i<n1){
            arr[k++]=L[i++];
        }

        while(j<n2){
            arr[k++]=R[j++];
        }

        return invc;
    }

    public int mergeSort(int[] arr, int l, int h) {
        int invc=0;
        if (l < h) {
            int mid = l + (h - l) / 2;
            invc += mergeSort(arr, l, mid);
            invc += mergeSort(arr, mid + 1, h);
            invc += merge(arr, l, mid, h);
        }
        return invc;
    }

    public int inversion(int[] arr, int n) {
        int l = 0, h = n - 1;
        int invc = 0;
        return mergeSort(arr, l, h);
    }

}
