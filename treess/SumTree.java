package treess;

public class SumTree {
    private boolean checkLeaf(Node root){
        if(root==null) return false;
        return root.left==null && root.right==null;
    }

    private int calSum(Node root){
        if(root==null) return 0;
        int l=calSum(root.left);
        int r=calSum(root.right);
        return l+root.v+r;
    }

    boolean isSumTreeBrute(Node root)
    {
        // Your code here
        if(root==null) return true;

        int l=calSum(root.left);
        int r=calSum(root.right);
        if(!checkLeaf(root) && l+r!=root.v) return false;


        boolean leftV=isSumTreeBrute(root.left);
        boolean rightV=isSumTreeBrute(root.right);
        return leftV && rightV;
    }
    //tc O(n2)

    //Optimised approach in O(n)
    private boolean isSum=true;
    private int calSums(Node root){
        if(root==null) return 0;
        int l=calSums(root.left);
        int r=calSums(root.right);
        if(!checkLeaf(root) && root.v!=(l+r)){
            isSum=false;
            return 0;
        }

        return l+root.v+r;
    }

    boolean isSumTree(Node root)
    {
        // Your code here
        if(root==null) return true;
        isSum=true;
        calSums(root);
        return isSum;
    }
}
