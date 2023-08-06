package treess;

public class InvertBt {
    private void invertBinaryTree(TreeNode root){
        if(root==null) return;

        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode temp=root;
        invertBinaryTree(temp);
        return root;
    }
}
