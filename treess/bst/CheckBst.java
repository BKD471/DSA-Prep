package treess.bst;

import treess.TreeNode;

public class CheckBst {
    private boolean validate(TreeNode root,Integer l,Integer r){
        if(root==null) return true;
        if( (l!=null && root.val<=l) || (r!=null && root.val>=r) ) return false;
        boolean leftTree=validate(root.left,l,root.val);
        boolean rightTree=validate(root.right,root.val,r);
        return leftTree && rightTree;
    }
    public boolean isValidBST(TreeNode root) {
        TreeNode temp=root;
        return validate(temp,null,null);
    }
}
