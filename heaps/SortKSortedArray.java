package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortKSortedArray {
    ArrayList<Integer> nearlySorted(int arr[], int n, int k)
    {
        // your code here
        ArrayList<Integer> res=new ArrayList<>();
        if(n==0) return res;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<=k;i++) pq.offer(arr[i]);

        res.add(pq.poll());
        for(int i=k+1;i<n;i++){
            pq.offer(arr[i]);
            res.add(pq.poll());
        }

        while(!pq.isEmpty()) res.add(pq.poll());
        return res;
    }

    // lgk+(n-k)lgk+k*lgk
}
