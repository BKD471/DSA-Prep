package treess.bst;

import treess.TreeNode;

public class SortedArrayToBst {
    private TreeNode constructBst(int[] nums, int l, int h){
        if(l>h) return null;
        int mid=l+(h-l)/2;
        int key=nums[mid];
        TreeNode root=new TreeNode(key);
        root.left=constructBst(nums,l,mid-1);
        root.right=constructBst(nums,mid+1,h);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        return constructBst(nums,0,n-1);
    }
}
