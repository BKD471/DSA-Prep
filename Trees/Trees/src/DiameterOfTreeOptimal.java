public class DiameterOfTreeOptimal{
    private int maxe=Integer.MIN_VALUE;
    public int findDiameter(TreeNode root){
        if(root==null) return 0;

        int l=findDiameter(root.left);
        int r=findDiameter(root.right);

        maxe=Math.max(maxe,l+r);
        return 1+Math.max(l,r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return maxe;
    }
}
