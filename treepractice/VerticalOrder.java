package treepractice;

import treess.TreeNode;

import java.util.*;

class Pair{
    TreeNode node;
    int v,h;
    Pair(TreeNode node,int v,int h){
        this.node=node;
        this.v=v;
        this.h=h;
    }
}
public class VerticalOrder {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;

        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0,0));

        while(!q.isEmpty()){
            Pair temp=q.poll();
            int v=temp.v;
            int h=temp.h;
            TreeNode node=temp.node;

            if(!map.containsKey(v)) map.put(v,new TreeMap<>());
            if(!map.get(v).containsKey(h)) map.get(v).put(h,new PriorityQueue<>());

            map.get(v).get(h).offer(node.val);
            if(node.left!=null) q.offer(new Pair(node.left,v-1,h+1));
            if(node.right!=null) q.offer(new Pair(node.right,v+1,h+1));
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> mp:map.values()){
            List<Integer> temp=new ArrayList<>();
            for(PriorityQueue<Integer> m:mp.values()){
                while(!m.isEmpty()){
                    temp.add(m.poll());
                }
            }
            res.add(temp);
        }
        return res;
    }
}
