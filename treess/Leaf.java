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

    //case 1 ---> any order
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

    //case 2 from left to right

    public static boolean checkLeaf(BinaryTreeNode<Integer> root){
        if(root==null) return false;
        return root.left==null && root.right==null;
    }

    public static void getLeaf(BinaryTreeNode<Integer> root,ArrayList<Integer> res){
        if(checkLeaf(root)){
            res.add(root.data);
            return;
        }

        if(root.left!=null) getLeaf(root.left,res);
        if(root.right!=null) getLeaf(root.right,res);
    }
    public static ArrayList<Integer> getLeafNodes(BinaryTreeNode<Integer> root){
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;

       getLeaf(root,res);
       return res;
    }

}
