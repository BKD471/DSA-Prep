import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null) return res;

        queue.add(root);
        while(!queue.isEmpty()){
            int sz=queue.size();
            List<Integer> temp=new ArrayList<>();
            while(sz>0){
                TreeNode tempRoot=queue.poll();
                temp.add(tempRoot.val);
                if(tempRoot.left!=null) queue.add(tempRoot.left);
                if(tempRoot.right!=null) queue.add(tempRoot.right);
                sz--;
            }

            res.add(temp);
        }
        return res;
    }
}
