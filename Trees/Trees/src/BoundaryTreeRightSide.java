import java.util.ArrayList;
import java.util.List;

public class BoundaryTreeRightSide {
    public void findRightView(TreeNode root,int level,List<Integer> res){
        if(root==null) return;

        if(res.size()==level) res.add(root.val);
        findRightView(root.right,level+1,res);
        findRightView(root.left,level+1,res);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        findRightView(root,0,res);
        return res;
    }
}
