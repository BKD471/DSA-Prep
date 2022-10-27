import java.util.ArrayList;
import java.util.List;

public class Utility {

    public void display(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public void displayArr(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
    }

    public void swap(int[] arr, int n, int m) {
        int t = arr[n];
        arr[n] = arr[m];
        arr[m] = t;
    }

    void displayListOfList(List<List<Integer>> arr){

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
}