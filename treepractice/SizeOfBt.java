package treepractice;

import treess.TreeNode;

public class SizeOfBt {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int l=countNodes(root.left);
        int r=countNodes(root.right);
        return 1+l+r;
    }
}
