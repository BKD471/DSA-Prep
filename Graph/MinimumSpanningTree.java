import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

class Pair1{
    int wt,node,parent;
    Pair1(int node,int parent,int wt){
        this.node=node;
        this.parent=parent;
        this.wt=wt;
    }
}
class Pair2{
    int v,w;
    Pair2(int v,int w){
        this.v=v;
        this.w=w;
    }
}

class Pair3{
    int u,v;
    Pair3(int u,int v){
        this.u=u;
        this.v=v;
    }
}


public class MinimumSpanningTree {
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        //Your code goes here
        ArrayList<ArrayList<Pair2>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        int m=edges.size();
        for(int i=0;i<m;i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            int w=edges.get(i).get(2);

            adj.get(u).add(new Pair2(v,w));
            adj.get(v).add(new Pair2(u,w));
        }

        boolean[] vis=new boolean[n];

        Comparator<Pair1> sortByDist=(x,y)-> x.wt<y.wt?-1 : x.wt>y.wt?1:0;
        PriorityQueue<Pair1> q=new PriorityQueue<>(sortByDist);
        q.offer(new Pair1(0,-1,0));

        List<Pair3> MST=new ArrayList<>();
        int maxSum=0;
        while(!q.isEmpty()){
            Pair1 temp=q.poll();

            int node=temp.node;
            int parent=temp.parent;
            int distance=temp.wt;


            if(!vis[node]){
                vis[node]=true;
                maxSum+=distance;
                MST.add(new Pair3(parent, node));
                for(Pair2 i:adj.get(node)){
                    int node1=i.v;
                    int distance1=i.w;
                    if(!vis[node1]) q.offer(new Pair1(node1, node, distance1));
                }
            }
        }
        return maxSum;
    }
}
