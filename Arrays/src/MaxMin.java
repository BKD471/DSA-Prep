public class MaxMin {

    public int[] maxmin(int[] arr,int n){

        int maxe,mine;
        int i=0;
        if(n%2!=0) {
            maxe = mine = arr[0];
            i=1;
        }else{
            maxe=Math.max(arr[0],arr[1]);
            mine=Math.min(arr[0],arr[1]);
            i=2;
        }

        for(;i<n-1;i=i+2){
            if(arr[i]>arr[i+1]){
                if(arr[i]>maxe) maxe=arr[i];
                if(arr[i+1]<mine) mine=arr[i+1];
            }else{
                if(arr[i+1]>maxe) maxe=arr[i+1];
                if(arr[i]<mine) mine=arr[i];
            }
        }

        return new int[]{maxe,mine};
    }

    public void display(int[] arr,int n){
        int[] res=maxmin(arr,n);
        for(int i=0;i<res.length;i++){
            System.out.print(" ->"+res[i]);
        }
    }


}
