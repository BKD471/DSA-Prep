package treess;

public class ChildrenSum {
    private static boolean checkLeaf(Node root){
        if(root==null) return false;
        return root.left==null && root.right==null;
    }

    private static boolean check(Node root){

        if(root==null || checkLeaf(root)) return true;

        int leftV=root.left==null? 0: root.left.v;
        int rightV=root.right==null? 0:root.right.v;
        if(root.v!=leftV+rightV) return false;

        boolean l=check(root.left);
        boolean r=check(root.right);
        return l && r;
    }

    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root==null) return 1;
        return !check(root) ? 0:1;
    }
}
