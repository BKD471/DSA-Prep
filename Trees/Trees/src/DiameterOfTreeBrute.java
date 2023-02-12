public class DiameterOfTreeBrute{
    private int maxe=Integer.MIN_VALUE;
    public int findHeight(TreeNode root){
        if(root==null) return 0;

        int l=1+findHeight(root.left);
        int r=1+findHeight(root.right);
        return Math.max(l,r);
    }
    public void findDiameter(TreeNode root){
        if(root==null) return;

        int l=findHeight(root.left);
        int r=findHeight(root.right);

        maxe=Math.max(maxe,l+r);

        findDiameter(root.left);
        findDiameter(root.right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return maxe;
    }
}
