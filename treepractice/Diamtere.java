package treepractice;

import treess.TreeNode;

public class Diamtere {
    private int res=0;
    private int height(TreeNode root){
        if(root==null) return -1;

        int l=height(root.left);
        int h=height(root.right);
        res=Math.max(res,l+h+2);
        return Math.max(l,h)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        res=0;
        height(root);
        return res;
    }
}
