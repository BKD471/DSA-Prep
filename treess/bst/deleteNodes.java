package treess.bst;

import treess.TreeNode;

public class deleteNodes {
    private int findMinFromRst(TreeNode root){
        if(root==null) return -1;

        TreeNode temp=root,prev=null;
        while(temp!=null){
            prev=temp;
            temp=temp.left;
        }
        return prev.val;
    }
    private TreeNode delete(TreeNode root,int key){
        if(root==null) return root;
        int v=root.val;

        if(v==key){
            if(root.left==null && root.right==null) return null;
            else if(root.left==null || root.right==null) {
                if(root.left!=null) return root.left;
                return root.right;
            }
            else{
                int x=findMinFromRst(root.right);
                root.val=x;
                root.right=delete(root.right,x);
                return root;
            }
        }

        if(v<key) root.right=deleteNode(root.right,key);
        else root.left=deleteNode(root.left,key);
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        TreeNode temp=root;
        return delete(temp,key);
    }
}
