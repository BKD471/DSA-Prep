package treess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNodes<T>
{
    public T data;
    TreeNodes<T> left;
    TreeNodes<T> right;

    TreeNodes(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
};

class RightView{
    public static ArrayList<Integer> getRightView(TreeNodes<Integer> root)
    {
        //    Write your code here.
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNodes<Integer>> q=new LinkedList<>();
        q.add(root);
        q.add(null);


        res.add(root.data);
        while(q.size()>1){
            TreeNodes<Integer> temp=q.poll();

            if(temp==null){
                TreeNodes<Integer> first=q.peek();
                res.add(first.data);
                q.add(null);
            }else{
                if(temp.right!=null) q.add(temp.right);
                if(temp.left!=null) q.add(temp.left);
            }
        }
        return res;

    }
}


public class LeftView {
    public static ArrayList<Integer> getLeftView(TreeNodes<Integer> root)
    {
        //    Write your code here.
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNodes<Integer>> q=new LinkedList<>();
        q.add(root);
        q.add(null);


        res.add(root.data);
        while(q.size()>1){
            TreeNodes<Integer> temp=q.poll();

            if(temp==null){
                TreeNodes<Integer> first=q.peek();
                res.add(first.data);
                q.add(null);
            }else{
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }
        return res;

    }
}
