public class MaxPathSum {
    private int maxe=Integer.MIN_VALUE;
    public int pathSum(TreeNode root){
        if(root==null) return 0;

        int l=Math.max(0,pathSum(root.left));
        int r=Math.max(0,pathSum(root.right));

        maxe=Math.max(maxe,root.val+l+r);
        return Math.max(l,r)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxe;
    }
}
