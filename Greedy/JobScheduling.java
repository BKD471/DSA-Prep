package Greedy;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.ArrayList;

class Pairs{
    int deadLine,payment;
    Pairs(int deadLine,int payment){
        this.deadLine=deadLine;
        this.payment=payment;
    }
}

public class JobScheduling {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n=A.size();

        Pairs[] jobs=new Pairs[n];
        for(int i=0;i<n;i++) jobs[i]=new Pairs(A.get(i),B.get(i));

        Arrays.sort(jobs,(c,d)-> (c.deadLine<d.deadLine)? -1 : (c.deadLine>d.deadLine)?1:0);
        int money=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(jobs[i].deadLine>pq.size()) pq.offer(jobs[i].payment);
            else{
                if(jobs[i].payment>pq.peek()){
                    pq.poll();
                    pq.offer(jobs[i].payment);
                }
            }
        }
        for(int i:pq) money+=i;
        return money;
    }
}
