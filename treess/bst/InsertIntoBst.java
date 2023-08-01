package treess.bst;

import treess.TreeNode;

public class InsertIntoBst {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode temp=root,parent=null;
        while(temp!=null){
            int v=temp.val;
            parent=temp;
            if(val<v) temp=temp.left;
            else temp=temp.right;
        }
        TreeNode node=new TreeNode(val);
        if(val<parent.val) parent.left=node;
        else parent.right=node;
        return root;

    }
}
