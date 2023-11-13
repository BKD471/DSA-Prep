package disjoint;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
class Disjoint{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    Disjoint(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node==parent.get(node)) return node;
        int u=findParent(parent.get(node));
        parent.set(node,u);
        return u;
    }

    public void union(int u,int v){
        int up=findParent(u);
        int vp=findParent(v);

        if(up==vp) return;
        if(size.get(up)<size.get(vp)){
            size.set(vp,size.get(up)+size.get(vp));
            parent.set(up,vp);
        }else{
            size.set(up,size.get(up)+size.get(vp));
            parent.set(vp,up);
        }
    }
}

class Pair{
    int u,v,w;
    Pair(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}
public class Kruskal {
    public static int kruskalMST(int n,int [][]edges) {
        //Write your code here
        ArrayList<Pair> adj=new ArrayList<>();
        Disjoint disjoint=new Disjoint(n);
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.add(new Pair(u, v, w));
        }
        Comparator<Pair> c=(a,b)-> a.w<b.w?-1:a.w>b.w?1:0;
        Collections.sort(adj,c);

        int sum=0;
        for(Pair temp:adj){
            int u1=temp.u;
            int v1=temp.v;
            int w1=temp.w;
            if(disjoint.findParent(u1)!=disjoint.findParent(v1)){
                sum+=w1;
                disjoint.union(u1, v1);
            }
        }
        return sum;
    }
}
