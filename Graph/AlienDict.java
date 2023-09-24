
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class AlienDict {
    private static List<Integer> Kahn(List<List<Integer>> adj, int k) {
        int m = adj.size();

        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int t : adj.get(i)) {
                inDegree[t]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i : adj.get(t)) {
                inDegree[i]--;
                if (inDegree[i] == 0) q.offer(i);
            }
            res.add(t);
        }
        return res;

    }

    public static String getAlienLanguage(String[] dict, int k) {
        // Write your code here.
        int n = dict.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                char u = s1.charAt(j);
                char v = s2.charAt(j);
                if (u != v) {
                    adj.get(u - 'a').add(v - 'a');
                    break;
                }
            }
        }
        List<Integer> safeNodes = Kahn(adj, k);

        String res = "";
        for (int t : safeNodes) {
            res = res + (char) (t + (int) ('a'));
        }

        return res;
    }

    public static void main(String[] args) {
        String[] dict={"caa","aaa","aab"};
        int k=3;
        System.out.println(getAlienLanguage(dict,k));
    }
}
