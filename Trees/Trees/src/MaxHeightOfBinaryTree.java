
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val=val;
        this.left=left;
        this.right=right;
    }

}



public class MaxHeightOfBinaryTree {
    public int findMaxHeight(TreeNode root){
        if(root==null) return 0;

        int left=1+findMaxHeight(root.left);
        int right=1+findMaxHeight(root.right);
        return Math.max(left,right);
    }

    public int maxDepth(TreeNode root){
        return findMaxHeight(root);
    }
}
