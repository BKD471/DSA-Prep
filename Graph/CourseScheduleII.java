import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegress=new int[numCourses];
        int m=prerequisites.length;

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=numCourses;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
            inDegress[u]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegress[i]==0) q.offer(i);
        }

        int cnt=0,index=0;
        int[] res=new int[numCourses];
        while(!q.isEmpty()){
            int t=q.poll();
            cnt++;
            for(int i:adj.get(t)){
                inDegress[i]--;
                if(inDegress[i]==0) q.offer(i);
            }
            res[index++]=t;
        }
        if(cnt!=numCourses) return new int[]{};

        return res;
    }
}
