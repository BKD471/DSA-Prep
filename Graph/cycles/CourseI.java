package cycles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseI {
    public static String canFinish(ArrayList<ArrayList<Integer>> arr, int n, int m) {
        //	Write your code here.

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

        int cnt=0;
        while(!q.isEmpty()){
            int temp=q.poll();
            cnt++;
            for(int t:adj.get(temp)){
                inDeg[t]--;
                if(inDeg[t]==0) q.offer(t);
            }
        }
        return cnt==n? "Yes":"No";
    }
}
