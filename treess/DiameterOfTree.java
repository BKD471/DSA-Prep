package treess;

public class DiameterOfTree {
    int mxLength=Integer.MIN_VALUE;
    public int calHeight(TreeNode root){
        if(root==null) return 0;

        int l=calHeight(root.left);
        int r=calHeight(root.right);
        return Math.max(l,r)+1;
    }
    public void preOrder(TreeNode root){
        if(root==null) return;

        int l=calHeight(root.left);
        int r=calHeight(root.right);
        mxLength=Math.max(mxLength,l+r);
        preOrder(root.left);
        preOrder(root.right);
    }

    public int diameterOfBinaryTreeBrute(TreeNode root) {
        if(root==null) return 0;
        preOrder(root);
        return mxLength;
    }
//o(n*width)

    //better

    public int calHeightBetter(TreeNode root){
        if(root==null) return 0;
        int l=calHeight(root.left);
        int r=calHeight(root.right);
        mxLength=Math.max(mxLength,l+r);
        return Math.max(l,r)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        calHeightBetter(root);
        return mxLength;
    }

    //o(n)
}
