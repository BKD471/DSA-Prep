import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class DisjointV{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DisjointV(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
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

        if(size.get(up)<size.get(vp)) {
            parent.set(up,vp);
            size.set(vp,size.get(up)+size.get(vp));
        }else{
            parent.set(vp,up);
            size.set(up,size.get(up)+size.get(vp));
        }
    }
}



public class MostStonesRemoved {
    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;
        for(int[] temp:stones){
            maxRow=Math.max(maxRow,temp[0]);
            maxCol=Math.max(maxCol,temp[1]);
        }

        DisjointV ds=new DisjointV(maxRow+maxCol+1);
        Map<Integer,Integer> hash=new HashMap<>();
        for(int[] arr:stones){
            int u=arr[0];
            int v=maxRow+arr[1]+1;
            ds.union(u,v);
            hash.put(u,1);
            hash.put(v,1);
        }

        int cnt=0;
        for(Map.Entry<Integer,Integer> mp:hash.entrySet()){
            int t=mp.getKey();
            if(ds.findParent(t)==t) cnt++;
        }
        return stones.length-cnt;
    }
}
