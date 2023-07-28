package treess;

public class SizeOfTree {
    public int findSize(TreeNode root){
        if(root==null) return 0;
        int left=findSize(root.left);
        int right=findSize(root.right);
        return left+right+1;
    }
}
