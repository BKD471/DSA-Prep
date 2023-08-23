package treess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> solve(TreeNode A){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(A==null) return res;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(A);
        q.offer(null);
        boolean flag=false;
        ArrayList<Integer> temp=new ArrayList<>();
        while(q.size()>1){
            TreeNode curr=q.poll();
            if(curr==null){
                res.add(temp);
                temp=new ArrayList<>();
                q.offer(null);
                flag=!flag;
            }else{
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
                if(flag) temp.add(0,curr.val);
                else temp.add(curr.val);
            }
        }
        res.add(temp);
        return res;
    }
}





