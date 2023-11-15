package disjoint;

import java.util.*;

class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int u){
        if(u==parent.get(u)) return u;
        int up=findParent(parent.get(u));
        parent.set(u,up);
        return up;
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
public class Batches {
    public static int solve(int n, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int k) {
        DisjointSet dis=new DisjointSet(n);
        for(List<Integer> temp:C){
            int u=temp.get(0);
            int v=temp.get(1);
            if(dis.findParent(u-1)!=dis.findParent(v-1)) dis.union(u-1,v-1);
        }

        Set<Integer> hash=new HashSet<>();
        List<Integer> par=dis.parent;
        for(int i:par) hash.add(dis.findParent(i));

        int cnt=0;
        for(int i:hash){
            int batchStrength=0;
            for(int j=0;j<par.size();j++){
                if(dis.findParent(par.get(j))==i) batchStrength+=B.get(j);
            }
            if(batchStrength>=k) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n=5;
        ArrayList<Integer> b=new ArrayList<>();
        b.add(1);b.add(2);b.add(3);b.add(4);b.add(5);
        ArrayList<ArrayList<Integer>> c=new ArrayList<>();

        ArrayList<Integer> t1=new ArrayList<>();
        ArrayList<Integer> t2=new ArrayList<>();
        t1.add(1);t1.add(5); c.add(t1);
        t2.add(2);t2.add(3);c.add(t2);
        int d=6;
        System.out.println(solve(n,b,c,d));
    }
}
