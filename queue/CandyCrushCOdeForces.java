package queue;

import java.util.LinkedList;
import java.util.Queue;

public class CandyCrushCOdeForces {
    public int candy(int n){
        if(n<=2) return n;

        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);

        int i=3;
        while(i<=n){
            int v=q.remove();
            int first=v*10+1;
            int second=v*10+2;
            if(i==n) return first;
            if(i+1==n) return  second;
            q.add(first);
            q.add(second);
            i+=2;
        }
        return  -1;
    }
}
