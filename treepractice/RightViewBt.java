package treepractice;

import treess.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBt {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();

        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);

        res.add(root.val);
        while(q.size()>1){
            TreeNode t=q.poll();
            if(t==null){
                res.add(q.peek().val);
                q.offer(null);
            }else{
                if(t.right!=null) q.offer(t.right);
                if(t.left!=null) q.offer(t.left);
            }
        }
        return res;
    }
}
