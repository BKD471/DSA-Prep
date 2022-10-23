
public class KthLargest {

    public void maxHeapify(int[] arr,int root,int n){

        int l=(2*root+1);
        int r=(2*root+2);
        int largest=root;
        if(l<n && arr[l]>arr[root]) largest=l;
        if(r<n && arr[r]>arr[largest]) largest=r;

        if(largest!=root){
            int t=arr[largest];
            arr[largest]=arr[root];
            arr[root]=t;
            maxHeapify(arr,largest,n);
        }
    }

    public int[] buildHeap(int[] arr,int n){

        for(int i=((n/2)-1);i>=0;i--){
            maxHeapify(arr,i,n);
        }
        return arr;
    }

    public void kthmax(int[] arr,int n,int k){
        int kthmax=0;
        int[] heap=buildHeap(arr,n);
        while(k-- > 0){
            kthmax=heap[0];
            int t=heap[0];
            heap[0]=heap[n-1];
            heap[n-1]=t;
            n--;
            maxHeapify(arr,0,n);
        }
        System.out.println("Kth Maximum Element is: "+kthmax);
    }
}
