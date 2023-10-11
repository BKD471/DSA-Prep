import java.util.List;
import java.util.ArrayList;

public class DisJoinSet {
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    DisJoinSet(int n){
        for(int i=0;i<n;i++) rank.add(0);
        for(int i=0;i<n;i++) parent.add(i);
    }

    public int findUltimateParent(int node){
        if(parent.get(node)==node) return node;
        int ulp=findUltimateParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void union(int u,int v){
        int ulimateParentU=findUltimateParent(u);
        int ulitimateParentV=findUltimateParent(v);
        if(ulimateParentU==ulitimateParentV) return;

        if(rank.get(ulimateParentU)==rank.get(ulitimateParentV)){
            parent.set(ulimateParentU,ulitimateParentV);
            int rankV=rank.get(ulitimateParentV);
            rank.set(ulitimateParentV,rankV+1);
        }
        else if(rank.get(ulitimateParentV)<rank.get(ulimateParentU)){
            parent.set(ulitimateParentV,ulimateParentU);
        }else parent.set(ulimateParentU,ulitimateParentV);
    }

}


class DisJointBySize{
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    DisJointBySize(int n){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int u){
        if(parent.get(u)==u) return u;
        int up=findParent(parent.get(u));
        parent.set(u,up);
        return up;
    }

    public void union(int u,int v){
        int up=findParent(u);
        int vp=findParent(v);
        if(up==vp) return;

        if(size.get(up)<size.get(vp)){
            parent.set(up,vp);
            size.set(vp,size.get(up)+size.get(vp));
        }else{
            parent.set(vp,up);
            size.set(up,size.get(up)+size.get(vp));
        }
    }
}

