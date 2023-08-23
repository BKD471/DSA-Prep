package treess;

import java.util.HashSet;
import java.util.Set;

public class CommonNodes {
    Set<Integer> hash;
    private static final int LIMIT=(int)(Math.pow(10,9)+7);
    int sum=0;
    CommonNodes(){
        hash=new HashSet<>();
    }

    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        if(!hash.add(root.val)) sum=(sum%LIMIT+root.val)%LIMIT;
        inOrder(root.right);
    }
    public int solve(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return 0;
        sum=0;
        inOrder(root1);
        inOrder(root2);
        return sum;
    }
}
