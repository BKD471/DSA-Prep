package shortestpath;

public class FloydWarshall {
    private static final int limit=(int)(Math.pow(10,8));
    public int[][] solve(int[][] grid) {
        int m=grid.length;
        int[][] cost=new int[m][m];

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j) cost[i][j]=0;
                else if(grid[i][j]==-1) cost[i][j]=limit;
                else cost[i][j]=grid[i][j];
            }
        }

        for(int via=0;via<m;via++){
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    if(cost[i][via]!=limit && cost[via][j]!=limit) cost[i][j]=Math.min(cost[i][j],cost[i][via]+cost[via][j]);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(cost[i][j]==limit) cost[i][j]=-1;
            }
        }
        return cost;
    }
}
