package treess;

public class IsBalanced {
    private int calHeight(TreeNode root){
        if(root==null) return 0;

        int l=calHeight(root.left);
        int r=calHeight(root.right);

        return Math.max(l,r)+1;
    }
    private boolean check(TreeNode root){
        if(root==null) return true;

        int lh=calHeight(root.left);
        int rh=calHeight(root.right);

        if(Math.abs(lh-rh)>1) return false;

        boolean l=check(root.left);
        boolean r=check(root.right);
        if(l==false || r==false) return false;
        return true;
    }
    public boolean isBalanced(TreeNode root) {
        return check(root);
    }

    //tc (n*n)
    //n-> for traversaing every node and n for find height

    private int checkItBebe(TreeNode root){
        if(root==null) return 0;

        int l=checkItBebe(root.left);
        int r=checkItBebe(root.right);
        if(l==-1 || r==-1) return -1;
        if(Math.abs(l-r)>1) return -1;
        return Math.max(l,r)+1;
    }
    public boolean isBalancedBetter(TreeNode root) {
        return checkItBebe(root)==-1?false:true;
    }
    //tc O(n)
}
