package treess;

import java.util.*;

class Pair{
    TreeNode node;
    int vertical;
    int horizontal;
    Pair(TreeNode node,int vertical,int horizontal){
        this.node=node;
        this.vertical=vertical;
        this.horizontal=horizontal;
    }
}


class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;

        q.offer(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode curr=p.node;
            int vertical=p.vertical;
            int horizontal=p.horizontal;


            if(!map.containsKey(vertical)) map.put(vertical, new TreeMap<>());
            if(!map.get(vertical).containsKey(horizontal)) map.get(vertical).put(horizontal, new PriorityQueue<>());
            map.get(vertical).get(horizontal).offer(curr.val);

            if(curr.left!=null)  q.offer(new Pair(curr.left,vertical-1,horizontal+1));
            if(curr.right!=null) q.offer(new Pair(curr.right,vertical+1,horizontal+1));

        }

        for(TreeMap<Integer,PriorityQueue<Integer>> temp:map.values()){
            List<Integer> tempRes=new ArrayList<>();
            for(PriorityQueue<Integer> t:temp.values()){
                while(!t.isEmpty()){
                    tempRes.add(t.poll());
                }
            }
            res.add(tempRes);
        }

        return res;
    }
}

