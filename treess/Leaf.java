package treess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Leaf {
    public static ArrayList<Integer> getLeafNode(BinaryTreeNode<Integer> root) {
        //Your code goes here
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            BinaryTreeNode<Integer> curr=q.poll();
            if(curr.left==null && curr.right==null) res.add(curr.data);
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }

        return res;
    }
}
