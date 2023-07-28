package treess;

public class HeightOfTree {
    public int findHeight(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return  0;
        int left=findHeight(root.left);
        int right=findHeight(root.right);
        return 1+Math.max(left,right);
    }
}
