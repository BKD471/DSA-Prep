package treess;

public class CountNodes {
    public int numOfNodes(TreeNode root){
        if(root==null) return 0;

        int l=numOfNodes(root.left);
        int r=numOfNodes(root.right);
        return l+r+1;
    }
}
