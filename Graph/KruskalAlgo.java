
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
        }
    }

    public int findSuperBoss(int u){
        if(parent.get(u)==u) return u;

        int pu=findSuperBoss(parent.get(u));
        parent.set(u,pu);
        return pu;
    }

    public void findUnion(int u,int v){
        int up=findSuperBoss(u);
        int vp=findSuperBoss(v);

        if(up==vp) return;
        if(rank.get(up)>rank.get(vp)){
            parent.set(vp,up);
        }else if(rank.get(vp)>rank.get(up)){
            parent.set(up, vp);
        }else{
            parent.set(up,vp);
            int rankv=rank.get(vp);
            rank.set(vp,rankv+1);
        }
    }
}

class PairGG{
    int wt,u,v;
    PairGG(int wt,int u,int v){
        this.wt=wt;
        this.u=u;
        this.v=v;
    }
}
public class KruskalAlgo {
        public static int kruskalMST(int n,int [][]edges) {
            //Write your code here
            Comparator<PairGG> c=(x,y)-> x.wt<y.wt?-1:x.wt>y.wt?1:0;
            PriorityQueue<PairGG> pq=new PriorityQueue<>(c);

            int m=edges.length;
            for(int i=0;i<m;i++){
                int u=edges[i][0];
                int v=edges[i][1];
                int w=edges[i][2];

                pq.offer(new PairGG(w, u, v));
            }

            DisjointSet ds=new DisjointSet(n);

            int mnSum=0;
            while(!pq.isEmpty()){
                PairGG temp=pq.poll();
                int u=temp.u;
                int v=temp.v;
                int w=temp.wt;

                if(ds.findSuperBoss(u)!=ds.findSuperBoss(v)){
                    mnSum+=w;
                    ds.findUnion(u, v);
                }
            }
            return mnSum;
        }
}
