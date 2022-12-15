import java.util.ArrayList;
import java.util.List;

public class CodeHelper {
    public static void reverse(int[] arr,int l,int h){
        while(l<h){
            int t=arr[l];
            arr[l]=arr[h];
            arr[h]=t;
            l++;
            h--;
        }
    }
    public static void displayHelper(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void displayArr(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
    }

    public static void swapHelper(int[] arr, int n, int m) {
        int t = arr[n];
        arr[n] = arr[m];
        arr[m] = t;
    }

    public static void displayListOfList(List<List<Integer>> arr){
        int n= arr.size();
        for(int i=0;i<n;i++){
            System.out.print("[ ");
            for(int j=0;j<arr.get(i).size();j++)
            {
                System.out.print(arr.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
    }

    public static int binarySearch(int[] nums,int key){
        int l=0,h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==key) return mid;

            if(nums[mid]>key) h=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}