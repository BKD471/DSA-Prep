package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinRopes {
    public int solve(ArrayList<Integer> nums) {
        int n=nums.size();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i:nums) pq.offer(i);

        int cost=0;
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();

            int c=first+second;
            cost+=c;
            pq.offer(c);
        }
        return cost;
    }
}
