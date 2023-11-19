package treepractice;

import treess.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class InPreBt {
    private static Map<Integer,Integer> hash=new HashMap<>();
    private static TreeNode createTree(int[] pre, int[] in, int sp, int ep, int si, int ei){
        if(sp>ep && si>ei) return null;
        int rootV=pre[sp];
        int indexIn=hash.get(rootV);
        int count=indexIn-si;
        TreeNode root=new TreeNode(rootV);
        root.left=createTree(pre,in,sp+1,sp+count,si,indexIn-1);
        root.right=createTree(pre,in,sp+count+1,ep,indexIn+1,ei);
        return root;
    }
    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        // Write your code here.
        int m=preorder.length,n=inorder.length;
        if(m!=n) return null;
        for(int i=0;i<n;i++) hash.put(inorder[i],i);
        return createTree(preorder,inorder,0,m-1,0,n-1);
    }
}
