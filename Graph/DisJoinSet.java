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
