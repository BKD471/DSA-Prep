package treess;

import java.util.*;

class Pair{
    TreeNode node;
    int distance;
    Pair(TreeNode node,int distance){
        this.node=node;
        this.distance=distance;
    }
}
public class AllNodesDistanceK {
    private List<TreeNode> rootToNodePath=new ArrayList<>();
    private List<Integer> res=new ArrayList<>();
    private Set<TreeNode> hash=new HashSet<>();
    private TreeNode search(TreeNode root,TreeNode target){
        if(root==null) return null;
        if(root==target) return root;
        TreeNode lft=search(root.left,target);
        TreeNode rt=search(root.right,target);
        if(lft!=null) return lft;
        if(rt!=null) return rt;
        return null;
    }
    private void findNodes(TreeNode root,int k){
        if(root==null) return;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        hash.add(root);

        while(!q.isEmpty()){
            Pair temp=q.poll();
            TreeNode node=temp.node;
            int distance=temp.distance;
            if(distance==k)  res.add(node.val);
            if(node.left!=null && !hash.contains(node.left)){
                hash.add(node.left);
                q.offer(new Pair(node.left,distance+1));
            }
            if(node.right!=null && !hash.contains(node.right)){
                hash.add(node.right);
                q.offer(new Pair(node.right,distance+1));
            }
        }
    }
    private boolean rootToNode(TreeNode root,TreeNode target){
        if(root==null) return false;

        if(root==target){
            rootToNodePath.add(root);
            return true;
        }
        boolean l=rootToNode(root.left,target);
        boolean r=rootToNode(root.right,target);

        if(l || r) rootToNodePath.add(root);
        return l || r;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res.clear();
        if(root==null) return res;
        TreeNode foundNode=search(root,target);
        findNodes(foundNode,k);

        //get the path
        rootToNodePath.clear();
        rootToNode(root,foundNode);

        k=k-1;
        for(int i=1;i<rootToNodePath.size();i++){
            TreeNode temp=rootToNodePath.get(i);
            findNodes(temp,k);
            k--;
        }
        return res;
    }
}
