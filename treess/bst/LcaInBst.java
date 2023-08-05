package treess.bst;

import treess.TreeNode;

public class LcaInBst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        TreeNode temp=root;
        while(temp!=null){
            if(p.val>temp.val && q.val>temp.val) temp=temp.right;
            else if(p.val<temp.val && q.val<temp.val) temp=temp.left;
            else break;
        }
        return temp;
    }
}
