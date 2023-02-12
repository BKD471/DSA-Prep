public class BalancedBinaryTree{
    public int findHeight(TreeNode root){
        if(root==null) return 0;
        int l=findHeight(root.left);
        int r=findHeight(root.right);

        if(l==-1 || r==-1) return -1;
        if(Math.abs(l-r)>1) return -1;
        return 1+Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        return findHeight(root)!=-1? true:false;
    }
}
