package treepractice.bst;

public class DeleteNode {
    private static int findMin(BinaryTreeNode root){
        if(root==null) return -1;
        BinaryTreeNode temp=root,parent=root;
        while(temp!=null){
            parent=temp;
            temp=temp.left;
        }
        return parent.data;
    }
    private static BinaryTreeNode delete(BinaryTreeNode root,int key){
        if(root==null) return root;
        int v=root.data;


        if(root.data==key){
            //no child
            if(root.left==null && root.right==null) return null;
                //single child
            else if(root.left==null || root.right==null){
                if(root.left!=null) return root.left;
                return root.right;
            }
            else{
                int x=findMin(root.right);
                root.data=x;
                root.right=delete(root.right, x);
                return root;
            }
        }

        if(key>root.data) root.right=delete(root.right,key);
        else root.left=delete(root.left,key);
        return root;
    }
    public static BinaryTreeNode deleteNode(BinaryTreeNode root, int key) {
        if(root==null) return root;
        BinaryTreeNode temp=root;
        return delete(temp, key);
    }
}
