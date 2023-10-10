import java.util.*;

class Disjoint{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();

    Disjoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
    }

    public int findBoss(int u){
        if(parent.get(u)==u) return u;
        int up=findBoss(parent.get(u));
        parent.set(u,up);
        return up;
    }

    public void findUnion(int u,int v){
        int up=findBoss(u);
        int vp=findBoss(v);
        if(up==vp) return;
        if(rank.get(up)<rank.get(vp)) parent.set(up,vp);
        else if(rank.get(vp)<rank.get(up)) parent.set(vp,up);
        else{
            parent.set(vp,up);
            int ranku=rank.get(up);
            rank.set(up,ranku+1);
        }
    }
}



public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n=accounts.size();
        Map<String,Integer> hash=new HashMap<>();
        Disjoint ds=new Disjoint(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<accounts.get(i).size();j++){
                if(j==0) continue;
                String temp=accounts.get(i).get(j);
                if(hash.containsKey(temp)){
                    int u=hash.get(temp);
                    ds.findUnion(u,i);
                }else hash.put(temp,i);
            }
        }

        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<n;i++) res.add(new ArrayList<>());
        for(Map.Entry<String,Integer> temp:hash.entrySet()){
            int value=temp.getValue();
            String key=temp.getKey();
            int findParent=ds.findBoss(value);
            res.get(findParent).add(key);
        }

        List<List<String>> finalResult=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(res.get(i).isEmpty()) continue;
            List<String> temp=res.get(i);
            Collections.sort(temp);
            if(accounts.get(i).isEmpty()) continue;
            String name=accounts.get(i).get(0);
            temp.add(0,name);
            finalResult.add(temp);
        }

        return finalResult;
    }
}
