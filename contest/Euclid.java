package contest;

import java.util.ArrayList;
import java.util.PriorityQueue;


class Pair {
    int index;
    int distance;

    Pair(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}


public class Euclid {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> nums, int k) {
        int n = nums.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n, (o1, o2) -> (o1.distance < o2.distance) ? -1 : (o1.distance > o2.distance) ? 1 : 0);

        for (int i = 0; i < n; i++) {
            int x = nums.get(i).get(0);
            int y = nums.get(i).get(1);
            Pair p = new Pair(i, x * x + y * y);
            pq.add(p);
        }

        for (int i = 1; i <= k; i++) {
            Pair p = pq.poll();
            res.add(nums.get(p.index));
        }
        return res;
    }
}

