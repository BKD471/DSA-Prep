public class NumOfProvinces {
    public void dfs(int indx,boolean[] vis,int[][] isConnected){
        vis[indx]=true;
        for(int i=0;i<isConnected[indx].length;i++){
            if(!vis[i] && isConnected[indx][i]==1){
                dfs(i,vis,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int nodes=isConnected.length;
        boolean[] vis=new boolean[nodes];

        int cnt=0;
        for(int i=0;i<nodes;i++){
            if(!vis[i]){
                dfs(i,vis,isConnected);
                cnt++;
            }
        }
        return cnt;
    }
}
