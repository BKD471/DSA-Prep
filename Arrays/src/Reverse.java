public class Reverse {
    public void swap(int[] arr,int a,int b){
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }
    public int[] reverse(int[] arr,int n){

        int l=0,h=n-1;
        while(l<=h){
            swap(arr,l,h);
            l++;
            h--;
        }
       return arr;
    }

    public void display(int[] arr,int n){
        int[] res=reverse(arr,n);
        for(int i=0;i<res.length;i++){
            System.out.print(" ->"+res[i]);
        }
    }
}
