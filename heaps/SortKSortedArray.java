package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortKSortedArray {

    public static int[] nearlySorted(int[] arr, int n, int k) {
        // Write your code here.
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        int[] res=new int[n];
        int index=0;
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);
            if(pq.size()>k) res[index++]=pq.poll();
        }
        while(!pq.isEmpty()) res[index++]=pq.poll();
        return res;
    }
    // lgk+(n-k)lgk+k*lgk
}
