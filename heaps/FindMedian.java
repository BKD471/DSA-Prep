package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedian {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        PriorityQueue<Integer> left=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right=new PriorityQueue<>();
        left.offer(arr[0]);

        int[] res=new int[n];
        res[0]=arr[0];

        for(int i=1;i<n;i++){
            if(arr[i]<=left.peek()){
                left.offer(arr[i]);
            }else{
                right.offer(arr[i]);
            }
            if(left.size()<right.size()){
                left.offer(right.poll());
            }
            if(left.size()-right.size()>1){
                right.offer(left.poll());
            }
            if(left.size()==right.size()){
                res[i]=(left.peek()+right.peek())/2;
            }else{
                res[i]=left.peek();
            }
        }
        return res;
    }
}
