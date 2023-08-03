package treess;

import java.util.ArrayList;
import java.util.List;

public class BtPathsFromRootToTargetNode {
    List<Integer> res=new ArrayList<>();
    private boolean pathFinder(TreeNode root,TreeNode target){
        if(root==null) return false;
        if(root==target){
            res.add(root.val);
            return true;
        }

        boolean tmp=pathFinder(root.left,target) || pathFinder(root.right,target);
        if(tmp) res.add(root.val);
        return tmp;
    }
    public List<Integer> findPath(TreeNode root,TreeNode target){
        if(root==null) return res;
        TreeNode temp=root;
        pathFinder(temp,target);
        return  res;
    }
}
