package treess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

class LcaBestApproach{
    private Map<TreeNode,ArrayList<Integer>> hash=new HashMap<>();
    private int count=0;
    private void prepareInOutTime(TreeNode root){
        if(root==null) return;
        hash.put(root,new ArrayList<>());
        hash.get(root).add(count);
        count++;
        prepareInOutTime(root.left);
        prepareInOutTime(root.right);
        hash.get(root).add(count);
        count++;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode x, TreeNode y) {
        if(root==null || x==null || y==null) return null;
        count=0;
        prepareInOutTime(root);
        for(TreeNode tmp:hash.keySet()){
            System.out.println(tmp.val+" "+hash.get(tmp));
        }

        TreeNode curr=root;
        while(curr!=null){
            int inTimeForLeft=9999;
            int outTimeForLeft=9999;
            if(curr.left!=null){
                inTimeForLeft=hash.get(curr.left).get(0);
                outTimeForLeft=hash.get(curr.left).get(1);
            }

            int inTimeForRight=9999;
            int outTimeForRight=9999;
            if(curr.right!=null) {
                inTimeForRight=hash.get(curr.right).get(0);
                outTimeForRight=hash.get(curr.right).get(1);
            }

            int inTimeForX=hash.get(x).get(0);
            int outTimeForX=hash.get(x).get(1);

            int inTimeForY=hash.get(y).get(0);
            int outTimeForY=hash.get(y).get(1);

            if(inTimeForLeft<=inTimeForX && inTimeForLeft<=inTimeForY &&
                    outTimeForLeft>=outTimeForX   && outTimeForLeft>=outTimeForY) curr=curr.left;
            else if(inTimeForRight<=inTimeForX && inTimeForRight<=inTimeForY &&
                    outTimeForRight>=outTimeForX   && outTimeForRight>=outTimeForY) curr=curr.right;
            else break;
        }
        return curr;
    }
    //tc O n+height
    //n-> for hashing in and out time
    //height for traversing and serching   height--> near to logn for almost balanced
 }
