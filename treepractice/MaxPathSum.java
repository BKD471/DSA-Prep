package treepractice;

import treess.TreeNode;

public class MaxPathSum {
    private static int res=Integer.MIN_VALUE;
    private static int solve(TreeNode root){
        if(root==null) return 0;
        int l=Math.max(0,solve(root.left));
        int r=Math.max(0,solve(root.right));
        res=Math.max(res,l+r+root.val);
        return Math.max(l,r)+root.val;
    }
    public static int maxPathSum(TreeNode root) {
        // Write your code here.
        if(root==null) return 0;
        res=Integer.MIN_VALUE;
        solve(root);
        return res;
    }
}
