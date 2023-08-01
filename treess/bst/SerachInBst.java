package treess.bst;

import treess.TreeNode;

public class SerachInBst {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return root;
        TreeNode temp=root;
        while(temp!=null){
            int v=temp.val;
            if(v==val) return temp;
            if(val<v) temp=temp.left;
            else temp=temp.right;
        }
        return null;
    }
}
