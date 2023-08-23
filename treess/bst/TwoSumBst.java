package treess.bst;

import treess.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumBst {
    private Map<Integer, TreeNode> hash=new HashMap<>();
    private void traverse(TreeNode root){
        if(root==null) return;
        hash.put(root.val,root);
        traverse(root.left);
        traverse(root.right);
    }

    private boolean checkPresence(TreeNode root,int k){
        if(root==null) return false;

        if(hash.containsKey(k-root.val) && hash.get(k-root.val)!=root) return true;
        boolean left=checkPresence(root.left,k);
        boolean right=checkPresence(root.right,k);
        return left || right;
    }
    public int t2Sum(TreeNode root, int k) {
        if(root==null) return 0;
        traverse(root);
        return checkPresence(root,k)==true? 1:0;
    }
}
