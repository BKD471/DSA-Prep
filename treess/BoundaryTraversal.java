package treess;

import java.util.* ;
import java.io.*;

class TreeNodess {
    int data;
    TreeNodess left;
    TreeNodess right;

    TreeNodess(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class BoundaryTraversal {
        private static boolean checkLeaf(TreeNodess root){
            if(root==null) return false;
            return root.left==null && root.right==null;
        }

        private static void  traverseRight(TreeNodess root,ArrayList<Integer> res){
            ArrayList<Integer> temp=new ArrayList<>();
            TreeNodess curr=root;
            while(curr!=null){
                if(!checkLeaf(curr)) temp.add(curr.data);
                if(curr.right!=null) curr=curr.right;
                else curr=curr.left;
            }
            for(int i=temp.size()-1;i>=0;i--) res.add(temp.get(i));
        }

        private static void  traverseLeft(TreeNodess root,ArrayList<Integer> res){
            TreeNodess curr=root;
            while(curr!=null){
                if(!checkLeaf(curr)) res.add(curr.data);
                if(curr.left!=null) curr=curr.left;
                else curr=curr.right;
            }
        }

        private static void traverseLeaf(TreeNodess root,ArrayList<Integer> res){
            if(checkLeaf(root)){
                res.add(root.data);
                return;
            }
            if(root.left!=null) traverseLeaf(root.left,res);
            if(root.right!=null) traverseLeaf(root.right,res);
        }

        public static ArrayList<Integer> traverseBoundary(TreeNodess root){
            // Write your code here.
            ArrayList<Integer> res=new ArrayList<>();
            if(root==null) return res;
            if(!checkLeaf(root)) res.add(root.data);

            traverseLeft(root.left, res);
            traverseLeaf(root, res);
            traverseRight(root.right, res);
            return res;

        }
}
