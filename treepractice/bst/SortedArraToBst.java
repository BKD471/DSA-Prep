package treepractice.bst;

import treess.TreeNode;

import java.util.ArrayList;

public class SortedArraToBst {
    private static TreeNode getTree(ArrayList<Integer> arr, int l, int h){
        if(l>h) return null;

        int mid=l+(h-l)/2;
        int key=arr.get(mid);
        TreeNode root=new TreeNode(key);
        root.left=getTree(arr,l,mid-1);
        root.right=getTree(arr,mid+1,h);
        return root;
    }
    public static TreeNode sortedArrToBST(ArrayList<Integer> arr, int n) {
        if(n==0) return null;
        int l=0,h=arr.size()-1;
        return getTree(arr,l,h);
    }
}
