package treepractice;

import treess.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodes<T>
{
    T data;
    TreeNodes<T> left;
    TreeNodes<T> right;

    TreeNodes(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
};

public class LevelOrderTraversal {
    public static List<Integer> levelOrder(TreeNodes<Integer> root){
        // Write your code here.
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNodes<Integer>> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNodes<Integer> temp=q.poll();
            res.add(temp.data);
            if(temp.left!=null) q.offer(temp.left);
            if(temp.right!=null) q.offer(temp.right);
        }
        return res;
    }

    public List<List<Integer>> levelOrderLevelWise(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);

        List<Integer> temp=new ArrayList<>();
        while(q.size()>1){
            TreeNode t=q.poll();
            if(t==null){
                res.add(temp);
                q.offer(null);
                temp=new ArrayList<>();
            }else{
                temp.add(t.val);
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
            }
        }
        res.add(temp);
        return res;
    }
}
