package treepractice.bst;

import treess.TreeNode;

public class InsertInBst {
    public static TreeNode insertionInBST(TreeNode root, int val) {
        // Write your code here.
        if(root==null) return root;

        TreeNode temp=root;
        TreeNode parent=root;
        while(temp!=null){
            parent=temp;
            if(temp.val==val) return root;
            else if(val>temp.val) temp=temp.right;
            else temp=temp.left;
        }

        TreeNode v=new TreeNode(val);
        if(parent.val<val) parent.right=v;
        else parent.left=v;
        return root;
    }
}
