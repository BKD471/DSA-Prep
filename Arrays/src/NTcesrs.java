//public class NBhikaris {
public class NTcesrs{
        public int[] solve(int A, int[][] B) {
            int n=B.length;
            int[] res=new int[A];
            for(int i=0;i<n;i++){
                int v=B[i][2];
                int beginIndex=B[i][0]-1;
                int endIndex=B[i][1]-1;
                res[beginIndex]+=v;
                if(endIndex+1<=A-1) res[endIndex+1]-=v;
            }

            for(int i=1;i<A;i++){
                res[i]=res[i-1]+res[i];
            }

            return res;
        }
}
