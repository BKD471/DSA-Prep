import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
class PairG{
    int source,dest;
    PairG(int source,int dest){
        this.source=source;
        this.dest=dest;
    }
}



public class cycleBfs {
        // Function to detect cycle in an undirected graph.
        private boolean bfs(ArrayList<ArrayList<Integer>> adj, int e, boolean[] vis){

            Queue<PairG> q=new LinkedList<>();
            q.offer(new PairG(-1,e));
            vis[e]=true;
            while(!q.isEmpty()){
                PairG temp=q.poll();

                int s=temp.source;
                int d=temp.dest;

                for(int t:adj.get(d)){
                    if(!vis[t]){
                        q.offer(new PairG(d,t));
                        vis[t]=true;
                    }

                    else if(s!=t) return true;
                }
            }
            return false;
        }

        public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
            boolean[] vis=new boolean[v];
            Arrays.fill(vis,false);

            for(int i=0;i<v;i++){
                if(!vis[i] && bfs(adj,i,vis)) return true;
            }
            return false;
        }
}
