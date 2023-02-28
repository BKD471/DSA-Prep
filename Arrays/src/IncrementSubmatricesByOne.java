public class IncrementSubmatricesByOne {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            int[][] res=new int[n][n];
            int size=queries.length;
            for(int i=0;i<size;i++){
                int row1=queries[i][0],row2=queries[i][2];
                int col1=queries[i][1],col2=queries[i][3];
                for(int j=row1;j<=row2;j++){
                    res[j][col1]++;
                    if(col2+1<=n-1) res[j][col2+1]--;
                }
            }


            for(int i=0;i<n;i++){
                for(int j=1;j<n;j++){
                    res[i][j]=res[i][j]+res[i][j-1];
                }
            }
            return res;
        }
}
