import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        if (adj.isEmpty()) return res;

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.offer(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int t = q.poll();
            res.add(t);

            for (int v : adj.get(t)) {
                if (!vis[v]) {
                    q.offer(v);
                    vis[v] = true;
                }
            }
        }
        return res;
    }

    // tc o(nodes + 2*edges) for ever nodes we are visiting all neighbour so total degree of graph +n
}
