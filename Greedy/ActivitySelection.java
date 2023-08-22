package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

class Pair{
    int start,end;
    Pair(int start,int end){
        this.start=start;
        this.end=end;
    }
}

public class ActivitySelection {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n=A.size();
        Pair[] timings=new Pair[n];
        for(int i=0;i<n;i++) timings[i]=new Pair(A.get(i),B.get(i));

        Arrays.sort(timings, (c,d)-> (c.end<d.end)? -1: (c.end>d.end)? 1:0);
        int count=1;
        int endTime=timings[0].end;
        for(int i=1;i<n;i++){
            if(timings[i].start>=endTime){
                count++;
                endTime=timings[i].end;
            }
        }
        return count;
    }
}
