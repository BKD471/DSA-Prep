package treess.bst;

import treess.TreeNode;

public class DistanceBetweenTwoNodes {
    private int height(TreeNode root, int k){
        if(root==null || root.val==k) return 0;
        if(root.val>k) return 1+height(root.left,k);
        else return 1+height(root.right,k);

    }
    public int solve(TreeNode root, int B, int C) {
        if(root==null) return 0;

        if(root.val>B && root.val>C) return solve(root.left,B,C);
        else if(root.val<B && root.val<C) return solve(root.right,B,C);
        else return height(root,B)+height(root,C);
    }
}
