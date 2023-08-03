package treess.bst;

import treess.TreeNode;

public class KthSmallestInBst {
    private int count=0;
    private int KthElement=-1;
    private void inOrder(TreeNode root, int k){
        if(root==null) return;

        inOrder(root.left,k);
        ++count;
        if(count==k){
            KthElement=root.val;
            return;
        }
        inOrder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode temp=root;
        inOrder(temp,k);
        return KthElement;
    }
}
