package treepractice;

import treess.TreeNode;
import java.util.*;


public class BottomView {
    public static ArrayList<Integer> getBottomView(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;

        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair temp=q.poll();

            int v=temp.v;
            TreeNode node=temp.node;

            map.put(v,node.val);
            if(node.left!=null) q.offer(new Pair(node.left, v-1));
            if(node.right!=null) q.offer(new Pair(node.right,v+1));
        }

        for(int i:map.values()) res.add(i);
        return res;
    }
}
