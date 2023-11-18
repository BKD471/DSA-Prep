package treepractice;

import treess.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBt {
    public static void printLeftView(TreeNodes<Integer> root) {
        // Write your code here.
        if(root==null) return;
        Queue<TreeNodes<Integer>> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);

        System.out.print(root.data+" ");
        while(q.size()>1){
            TreeNodes<Integer> t=q.poll();
            if(t==null){
                System.out.print(q.peek().data+" ");
                q.offer(null);
            }else{
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
            }
        }
    }
}
