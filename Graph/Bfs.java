import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> queue=new LinkedList<>();
        boolean[] vis=new boolean[V];
        ArrayList<Integer> bfs=new ArrayList<>();
        queue.add(0);
        vis[0]=true;

        while(!queue.isEmpty()){
            Integer temp=queue.poll();
            bfs.add(temp);

            for(Integer i:adj.get(temp)){
                if(!vis[i]){
                    queue.add(i);
                    vis[i]=true;
                }
            }
        }
        return bfs;
    }
}
