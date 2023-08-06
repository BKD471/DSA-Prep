package treess;

public class PathSum {
    private boolean check(TreeNode root,int k){
        if(root==null) return false;
        if(root.left==null && root.right==null) return root.val==k;
        return check(root.left,k-root.val) || check(root.right,k-root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        TreeNode temp=root;
        return check(temp,targetSum);
    }
}
