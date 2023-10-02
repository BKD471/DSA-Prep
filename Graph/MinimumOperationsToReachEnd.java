
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class PairM{
    int v,count;
    PairM(int count,int v){
        this.v=v;
        this.count=count;
    }
}

public class MinimumOperationsToReachEnd {
    private static final int LIMIT=(int)(Math.pow(10,3));
    public static int minimumOperations(int n, int start, int end, int []a) {
        // Write your code here
        int m=a.length;
        int[] dist=new int[LIMIT];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[start]=0;
        Queue<PairM> q=new LinkedList<>();
        q.offer(new PairM(0, start));

        while(!q.isEmpty()){
            PairM temp=q.poll();
            int v=temp.v;
            int cnt=temp.count;
            for(int i:a){
                int res=((i%LIMIT)*(v%LIMIT))%LIMIT;
                if(dist[res]>cnt+1){
                    dist[res]=cnt+1;
                    q.offer(new PairM(cnt+1,res));
                }
            }
        }
        if(dist[end]==Integer.MAX_VALUE) return -1;
        return dist[end];
    }
}
