public class SymmetricTree {
    public boolean checkIdentical(TreeNode a,TreeNode b){
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;

        if(a.val==b.val) return checkIdentical(a.right,b.left) && checkIdentical(a.left,b.right);
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return checkIdentical(root.left,root.right);
    }
}
