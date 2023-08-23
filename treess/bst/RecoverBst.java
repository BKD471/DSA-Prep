package treess.bst;

import treess.TreeNode;

public class RecoverBst {
    TreeNode prev=null,first=null,second=null;
    private void swapNodes(TreeNode root1,TreeNode root2){
        int t=root1.val;
        root1.val=root2.val;
        root2.val=t;
    }
    private void inOrder(TreeNode root){
        if(root==null) return;

        inOrder(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null) first=prev;
            second=root;
        }
        prev=root;
        inOrder(root.right);
    }

    public int[] recoverTree(TreeNode root) {
        int[] res=new int[2];
        if(root==null) return res;

        inOrder(root);
        swapNodes(first,second);
        return new int[]{first.val,second.val};
    }
}
