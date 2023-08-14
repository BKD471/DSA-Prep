package treess;

public class Flatten {
    public void fllaten(TreeNode root){
        if(root==null) return;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode temp=curr.left;
                while(temp.right!=null) temp=temp.right;
                temp.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }else curr=curr.right;
        }
    }
}
