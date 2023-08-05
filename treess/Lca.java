package treess;
import java.util.ArrayList;
import java.util.List;

public class Lca {
    List<TreeNode> left=new ArrayList<>();
    List<TreeNode> right=new ArrayList<>();
    private boolean findRootToNode(TreeNode root,TreeNode target,List<TreeNode> tmp){
        if(root==null) return false;
        if(root==target){
            tmp.add(root);
            return true;
        }
        boolean t=findRootToNode(root.left,target,tmp) || findRootToNode(root.right,target,tmp);
        if(t) tmp.add(root);
        return t;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) return null;
        boolean l1=findRootToNode(root,p,left);
        boolean r1=findRootToNode(root,q,right);
        if(!l1 && !r1) return null;


        int m=left.size()-1,n=right.size()-1;
        TreeNode res=null;
        while(m>=0 && n>=0){
            if(left.get(m)==right.get(n)) res=left.get(m);
            m--;
            n--;
        }

        return res;
    }
}
