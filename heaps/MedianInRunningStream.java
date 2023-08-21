package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInRunningStream {
        PriorityQueue<Integer> leftHeap;
        PriorityQueue<Integer> rightHeap;
        public MedianInRunningStream() {
            leftHeap=new PriorityQueue<>(Comparator.reverseOrder());
            rightHeap=new PriorityQueue<>();
        }

        public void addNum(int num) {
            int n=leftHeap.size();
            if(n==0) leftHeap.offer(num);
            else{
                int left=leftHeap.peek();
                if(num<=left) leftHeap.offer(num);
                else rightHeap.offer(num);
                if(leftHeap.size()<rightHeap.size()) leftHeap.offer(rightHeap.poll());
                if(leftHeap.size()-rightHeap.size()>1) rightHeap.offer(leftHeap.poll());
            }
        }

        public double findMedian() {
            double left=0;
            if(!leftHeap.isEmpty()) left=leftHeap.peek();
            double right=0;
            if(!rightHeap.isEmpty()) right=rightHeap.peek();
            if(leftHeap.size()==rightHeap.size()) return (double)((left+right)/2);
            return left;
        }
}
