public class SameTree {
    public boolean checkTree(TreeNode a,TreeNode b){
        if(a== null && b==null) return true;
        if(a==null || b==null) return false;

        if(a.val==b.val) return checkTree(a.right,b.right) && checkTree(a.left,b.left);
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkTree(p,q);
    }
}
