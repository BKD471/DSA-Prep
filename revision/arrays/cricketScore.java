package revision.arrays;

class cricketScore{
    public long[] cricketScore(int[] A, int[][] B) {
        int n=A.length;
        int m=B.length;

        long ps[]=new long[n];
        ps[0]=A[0];
        for(int i=1;i<n;i++) ps[i]=ps[i-1]+A[i];

        long[] res=new long[m];
        for(int i=0;i<m;i++){
            int start=B[i][0], end=B[i][1];
            if(start==0) res[i]=ps[end];
            else res[i]=ps[end]-ps[start-1];
        }

        return res;
    }
}