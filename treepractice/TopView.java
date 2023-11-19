package treepractice;

import treess.TreeNode;

import java.util.*;

class Pair{
    TreeNode node;
    int v;
    Pair(TreeNode node,int v){
        this.node=node;
        this.v=v;
    }

}
public class TopView {
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            Pair temp=q.poll();
            int v=temp.v;
            TreeNode node=temp.node;

            if(!map.containsKey(v)) map.put(v,node.val);
            if(node.left!=null)  q.offer(new Pair(node.left,v-1));
            if(node.right!=null) q.offer(new Pair(node.right,v+1));
        }


        for(int t:map.values()) res.add(t);
        return res;
    }
}
