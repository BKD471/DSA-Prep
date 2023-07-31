package treess;

public class IdenticalTrees {
    public boolean isSameTree(TreeNode m, TreeNode n) {
        if(m==null || n==null) return m==n;
        return m.val==n.val && isSameTree(m.left,n.left) && isSameTree(m.right,n.right);
    }
}
