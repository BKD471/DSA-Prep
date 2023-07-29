package treess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//case 1
public class LevelOrderLeftToRight {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);
        q.add(null);
        List<Integer> temp=new ArrayList<>();
        while(q.size()>1){
            TreeNode curr=q.poll();
            if(curr==null){
                res.add(temp);
                q.add(null);
                temp=new ArrayList<>();
            }else{
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        res.add(temp);
        return res;
    }
}

//case 2
class LevelOrderRightToLeft {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);
        q.add(null);
        List<Integer> temp=new ArrayList<>();
        while(q.size()>1){
            TreeNode curr=q.poll();
            if(curr==null){
                res.add(temp);
                q.add(null);
                temp=new ArrayList<>();
            }else{
                temp.add(curr.val);
                if(curr.right!=null) q.add(curr.right);
                if(curr.left!=null) q.add(curr.left);
            }
        }
        res.add(temp);
        return res;
    }
}
