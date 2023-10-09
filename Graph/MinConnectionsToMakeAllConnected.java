
import java.util.List;
import java.util.ArrayList;

class DisjointSet1{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    DisjointSet1(int n){
        for(int i=0;i<n;i++){
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


public class MinConnectionsToMakeAllConnected {
    public int makeConnected(int n, int[][] edges) {
        int m=edges.length;
        DisjointSet1 ds=new DisjointSet1(n);
        int extraEdges=0;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(ds.findSuperBoss(u)!=ds.findSuperBoss(v)) ds.findUnion(u,v);
            else extraEdges++;
        }

        int minComponents=0;
        for(int i=0;i<n;i++) if(ds.findSuperBoss(i)==i) minComponents++;

        minComponents--;
        if(extraEdges>=minComponents) return minComponents;
        return -1;
    }
}
