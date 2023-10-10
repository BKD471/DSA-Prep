
import java.util.List;
import java.util.ArrayList;


class Disjoints{

    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();


    Disjoints(int n){
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

    public void union(int u,int v){
        int up=findBoss(u);
        int vp=findBoss(v);
        if(up==vp) return;
        if(rank.get(up)<rank.get(vp)) parent.set(up,vp);
        else if(rank.get(vp)<rank.get(up)) parent.set(vp,up);
        else{
            parent.set(up,vp);
            int rankv=rank.get(vp);
            rank.set(vp,rankv+1);
        }
    }
}
public class IslandsIIQueries {
    public static int[] numberOfIslandII(int n, int m, int [][]queries, int q) {
        // Write your code here.

        int[][] grid=new int[n][m];

        int vertices=m*n;
        Disjoints ds=new Disjoints(vertices);

        int size=queries.length;
        boolean[][] vis=new boolean[n][m];
        int cnt=0;
        int[] res=new int[size];
        int index=0;
        for(int i=0;i<size;i++){
            int row=queries[i][0];
            int col=queries[i][1];
            if(vis[row][col]){
                res[index++]=cnt;
                continue;
            }
            vis[row][col]=true;
            cnt++;
            int[] r1={-1,0,1,0};
            int[] c1={0,-1,0,1};
            for(int j=0;j<4;j++){
                int nr=row+r1[j];
                int cr=col+c1[j];
                if(nr>=0 && cr>=0 && nr<n && cr<m && vis[nr][cr]){
                    int u=row*m+col;
                    int v=nr*m+cr;
                    if(ds.findBoss(u)!=ds.findBoss(v)){
                        ds.union(u,v);
                        cnt--;
                    }
                }
            }
            res[index++]=cnt;
        }
        return res;
    }
}
