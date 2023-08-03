package treess;

import java.util.List;
import java.util.ArrayList;
public class pathsToLeaf {
    public void dfs(TreeNode root,String path,List<String> res){
        path+="->"+root.val;
        if(root.left==null && root.right==null){
            res.add(path);
            return;
        }

        if(root.left!=null) dfs(root.left,path,res);
        if(root.right!=null) dfs(root.right,path,res);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        String v=Integer.toString(root.val);
        if(root.left==null && root.right==null) res.add(v);

        if(root.left!=null) dfs(root.left,v,res);
        if(root.right!=null) dfs(root.right,v,res);
        return res;
    }
}
