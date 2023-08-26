package treess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res=new ArrayList<>();
        if(A==null) return res;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(A);

        while(q.size()>0){
            TreeNode curr=q.poll();
            if(curr==null){
                res.add(-1);
                continue;
            }
            res.add(curr.val);
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return res;
    }
}
