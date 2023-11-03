package cycles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseII {
    public static List<Integer> findSchedule(int n, List<List<Integer>> arr) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        int[] inDeg=new int[n];
        for(int i=0;i<arr.size();i++){
            int u=arr.get(i).get(1);
            int v=arr.get(i).get(0);
            adj.get(u-1).add(v-1);
            inDeg[v-1]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDeg[i]==0) q.offer(i);
        }

        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int temp=q.poll();
            res.add(temp+1);
            for(int t:adj.get(temp)){
                inDeg[t]--;
                if(inDeg[t]==0) q.offer(t);
            }
        }

        if(res.size()==n) return res;
        return new ArrayList<>();
    }
}
