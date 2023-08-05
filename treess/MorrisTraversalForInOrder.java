package treess;

import java.util.ArrayList;
import java.util.List;
public class MorrisTraversalForInOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        TreeNode curr=root;
        while(curr!=null){

            if(curr.left==null){
                res.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode temp=curr.left;
                while(temp.right!=null && temp.right!=curr) temp=temp.right;
                if(temp.right==null){
                    temp.right=curr;
                    curr=curr.left;
                }else if(temp.right==curr){
                    temp.right=null;
                    res.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return res;
    }
}
