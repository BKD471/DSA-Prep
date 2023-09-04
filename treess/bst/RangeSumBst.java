package treess.bst;

import treess.TreeNode;

public class RangeSumBst {
    private int sum=0;
    private void calSum(TreeNode root,int a,int b){
        if(root==null) return;
        calSum(root.left,a,b);
        if(root.val>=a && root.val<=b) sum+=root.val;
        calSum(root.right,a,b);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        calSum(root,low,high);
        return sum;
    }
}
