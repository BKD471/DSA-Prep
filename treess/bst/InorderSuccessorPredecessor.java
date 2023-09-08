package treess.bst;

class TreeNode1{
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}


public class InorderSuccessorPredecessor {
    private TreeNode1 inOrderSucessor(TreeNode1 root,TreeNode1 key){
        TreeNode1 successor=null;
        TreeNode1 temp=root;

        int k=key.val;
        while(temp!=null){
            if(k>=temp.val) temp=temp.right;
            else {
                successor=temp;
                temp=temp.left;
            }
        }
        return successor;
    }

    private TreeNode1 inOrderPredecessor(TreeNode1 root,TreeNode1 key){
         TreeNode1 predecessor=null;
         int k=key.val;
         TreeNode1 temp=root;
         while(temp!=null){
             if(k<=temp.val) temp=temp.left;
             else{
                 predecessor=temp;
                 temp=temp.right;
             }
         }
         return predecessor;
    }
}
