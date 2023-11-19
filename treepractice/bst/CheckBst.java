package treepractice.bst;

import treess.TreeNode;

public class CheckBst {
    private static boolean check(TreeNode root, long l, long h){
        if(root==null) return true;

        if(root.val<=l || root.val>=h) return false;
        boolean lt=check(root.left, l, root.val);
        boolean rt=check(root.right, root.val, h);
        return lt && rt;
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
