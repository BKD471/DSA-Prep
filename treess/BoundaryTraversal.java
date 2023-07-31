package treess;

import java.util.* ;
import java.io.*;


public class BoundaryTraversal {
        private static boolean checkLeaf(TreeNode root){
            if(root==null) return false;
            return root.left==null && root.right==null;
        }

        private static void  traverseRight(TreeNode root,ArrayList<Integer> res){
            ArrayList<Integer> temp=new ArrayList<>();
            TreeNode curr=root;
            while(curr!=null){
                if(!checkLeaf(curr)) temp.add(curr.val);
                if(curr.right!=null) curr=curr.right;
                else curr=curr.left;
            }
            for(int i=temp.size()-1;i>=0;i--) res.add(temp.get(i));
        }

        private static void  traverseLeft(TreeNode root,ArrayList<Integer> res){
            TreeNode curr=root;
            while(curr!=null){
                if(!checkLeaf(curr)) res.add(curr.val);
                if(curr.left!=null) curr=curr.left;
                else curr=curr.right;
            }
        }

        private static void traverseLeaf(TreeNode root,ArrayList<Integer> res){
            if(checkLeaf(root)){
                res.add(root.val);
                return;
            }
            if(root.left!=null) traverseLeaf(root.left,res);
            if(root.right!=null) traverseLeaf(root.right,res);
        }

        public static ArrayList<Integer> traverseBoundary(TreeNode root){
            // Write your code here.
            ArrayList<Integer> res=new ArrayList<>();
            if(root==null) return res;
            if(!checkLeaf(root)) res.add(root.val);

            traverseLeft(root.left, res);
            traverseLeaf(root, res);
            traverseRight(root.right, res);
            return res;

        }
}
