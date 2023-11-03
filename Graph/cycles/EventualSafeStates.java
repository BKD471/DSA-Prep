package cycles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class EventualSafeStates {
    public static ArrayList<Integer> safeNodes(int edges[][], int n, int e) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        int[] inDeg=new int[n];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(v).add(u);
            inDeg[u]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDeg[i]==0) q.offer(i);
        }

        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int temp=q.poll();
            res.add(temp);
            for(int t:adj.get(temp)){
                inDeg[t]--;
                if(inDeg[t]==0) q.offer(t);
            }
        }

        Collections.sort(res);
        return res;
    }
}
