package treess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Deserialize {
    public TreeNode solve(ArrayList<Integer> res) {
        int n=res.size();

        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(res.get(0));
        q.offer(root);

        for(int i=1;i<n;i++){
            TreeNode curr=q.poll();

            int leftValue=res.get(i);
            if(leftValue!=-1){
                TreeNode left=new TreeNode(leftValue);
                curr.left=left;
                q.offer(left);
            }

            int rightValue=res.get(++i);
            if(rightValue!=-1){
                TreeNode right=new TreeNode(rightValue);
                curr.right=right;
                q.offer(right);
            }
        }
        return root;
    }
}
