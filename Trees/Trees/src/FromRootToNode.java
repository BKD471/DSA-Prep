import java.util.ArrayList;

public class FromRootToNode {
    public boolean pathToNode(TreeNode root,ArrayList<Integer> res,int key){
        if(root==null) return false;

        res.add(root.val);
        if(root.val==key) return true;
        if(pathToNode(root.left,res,key) || pathToNode(root.right,res,key)) return true;

        res.remove(res.size()-1);
        return false;
    }

    public ArrayList<Integer> solve(TreeNode root, int B) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;
        pathToNode(root,res,B);
        return res;
    }
}
