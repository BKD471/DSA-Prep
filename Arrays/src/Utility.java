public class Utility {

    public void display(int[] arr){
        int n= arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

    public  void swap(int[] arr,int n,int m){
        int t=arr[n];
        arr[n]=arr[m];
        arr[m]=t;
    }
}
