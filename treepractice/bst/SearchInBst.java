package treepractice.bst;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class SearchInBst {
    public static boolean searchInBST(BinaryTreeNode root, int x) {
        // Write your code here.
        if(root==null) return false;

        BinaryTreeNode temp=root;
        while(temp!=null){
            if(temp.data==x) return true;
            else if(x>temp.data) temp=temp.right;
            else temp=temp.left;
        }
        return false;
    }
}
