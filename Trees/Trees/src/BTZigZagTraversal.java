import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();

        if(root==null) return res;

        queue.add(root);
        boolean flag=true;
        while(!queue.isEmpty()){
            int sz=queue.size();
            List<Integer> temp=new ArrayList<>();
            while(sz>0){
                TreeNode tempRoot=queue.poll();
                if(tempRoot.left!=null) queue.add(tempRoot.left);
                if(tempRoot.right!=null) queue.add(tempRoot.right);

                if(flag==true) temp.add(tempRoot.val);
                else temp.add(0,tempRoot.val);
                sz--;
            }
            flag=!flag;
            res.add(temp);
        }
        return res;
    }
}
