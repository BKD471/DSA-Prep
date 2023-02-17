import java.util.ArrayList;
import java.util.List;

public class LCABrute {
    public boolean findPath(TreeNode root,TreeNode key,List<TreeNode> res){

        if(root==null) return false;

        res.add(root);
        if(root.val==key.val) return true;
        if( findPath(root.left,key,res) || findPath(root.right,key,res)) return true;

        res.remove(res.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> left=new ArrayList<>();
        List<TreeNode> right=new ArrayList<>();

        findPath(root,p,left);
        findPath(root,q,right);

        TreeNode res=root;

        int i=0,j=0;
        int m=left.size(),n=right.size();

        while(i<m && j<n){
            if(left.get(i)==right.get(j)) res=left.get(i);
            else break;
            i++;
            j++;
        }
        return res;
    }
}
