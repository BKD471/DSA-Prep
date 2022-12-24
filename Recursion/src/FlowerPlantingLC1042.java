import java.util.Arrays;

import static helper.CodeHelper.displayArrHelper;

class Solution10 {
    public static boolean isPossible(boolean[][] graph,int[] colors,int color,int node,int n){
        for(int i=0;i<n;i++){
            if(graph[node][i]==true){
                if(colors[i]==color) return false;
            }
        }
        return true;
    }
    public static boolean solve(boolean[][] graph,int[] colors,int n,int node){
        if(node==n) return true;

        for(int color=1;color<=n;color++){
            if(isPossible(graph,colors,color,node,n)){
                colors[node]=color;
                if(solve(graph,colors,n,node+1)==true) return true;
                else colors[node]=0;
            }
        }
        return false;
    }

    public static int[] gardenNoAdj(int n, int[][] path) {
        int[] colors=new int[n];
        Arrays.fill(colors,0);

        boolean[][] graph=new boolean[n][n];
        for(int i=0;i<path.length;i++){
            int j=0;
            int u=path[i][j]-1;
            int v=path[i][j+1]-1;
            graph[u][v]=true;
            graph[v][u]=true;
        }
        solve(graph,colors,n,0);
        return colors;
    }
}


public class FlowerPlantingLC1042 {
    public static void main(String[] args) {
        int[][] paths={{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        int[] res=Solution10.gardenNoAdj(4,paths);
        displayArrHelper(res);
    }
}
