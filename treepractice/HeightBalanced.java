package treepractice;

import treess.TreeNode;

public class HeightBalanced {
    private static boolean isBalanced=true;
    private static int getHeight(TreeNode root){
        if(root==null) return 0;

        int l=getHeight(root.left);
        int r=getHeight(root.right);
        if(Math.abs(l-r)>1) isBalanced=false;
        return Math.max(l,r)+1;
    }
    public static boolean isBalancedBT(TreeNode root) {
        // Write your code here.
        isBalanced=true;
        getHeight(root);
        return isBalanced;
    }
}
