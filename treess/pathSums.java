package treess;

public class pathSums {
    private boolean checkLeaf(TreeNode root){
        if(root==null) return false;
        return root.left==null && root.right==null;
    }

    private boolean check(TreeNode root,int k){
        if(root==null) return false;
        if(checkLeaf(root) ) return k==root.val;
        boolean l=check(root.left,k-root.val);
        boolean r=check(root.right,k-root.val);
        return l || r;

    }
    public int hasPathSum(TreeNode root, int k) {
        if(root==null && k==0) return 1;
        return check(root, k) ? 1:0;
    }
}
