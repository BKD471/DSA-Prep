import java.util.ArrayList;
import java.util.List;

public class RootTLeaf {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        String path=Integer.toString(root.val);

        if(root.left==null && root.right==null) res.add(path);
        if(root.left!=null) dfs(root.left,path,res);
        if(root.right!=null) dfs(root.right,path,res);

        return res;
    }

    public void dfs(TreeNode root,String path,List<String> res){
        path+="->"+root.val;

        if(root.left==null && root.right==null){
            res.add(path);
            return;
        }

        if(root.left!=null) dfs(root.left,path,res);
        if(root.right!=null) dfs(root.right,path,res);
    }
}
