package treess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxIneachLevel {
    public ArrayList<Integer> largestValues(Node root)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;

        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int maxV=Integer.MIN_VALUE;
        while(q.size()>1){
            Node temp=q.poll();

            if(temp==null){
                res.add(maxV);
                q.offer(null);
                maxV=Integer.MIN_VALUE;
            }else{
                maxV=Math.max(maxV,temp.v);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
        }

        res.add(maxV);
        return res;
    }
}
