import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int cnt=0;
        while(!q.isEmpty()){
            int t=q.poll();
            cnt++;
            for(int i:adj.get(t)){
                inDegress[i]--;
                if(inDegress[i]==0) q.offer(i);
            }
        }
        if(cnt==numCourses) return true;
        return false;
    }
}
