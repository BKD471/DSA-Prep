package bfsdfs;

import java.util.ArrayList;
import java.util.Arrays;

public class Bipartite {
    private static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int[] c,int color,int node){
        c[node]=color;
        for(int t:adj.get(node)){
            if(c[t]==-1) {
                if(checkBipartite(adj, vis,c, 1-color, t)==false) return false;
            }else if(c[t]==color) return false;
        }
        return true;
    }

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        int n=edges.size();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<edges.get(i).size();j++){
                int value=edges.get(i).get(j);
                if(value==1) adj.get(i).add(j);
            }
        }

        boolean[] vis=new boolean[n];
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1 && !checkBipartite(adj,vis,color, 0, i)) return false;
        }
        return true;
    }
}
