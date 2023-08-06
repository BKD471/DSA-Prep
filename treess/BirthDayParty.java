package treess;

class TreeNodesss<T>
{
    T data;
    TreeNodesss<T> left;
    TreeNodesss<T> right;

    TreeNodesss(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BirthDayParty {
    private static boolean isEqual=false;
    private static long calSum(TreeNodesss<Integer> root){
        if(root==null) return 0L;
        long l=calSum(root.left);
        long r=calSum(root.right);
        return l+r+root.data;
    }
    private static  long check(TreeNodesss<Integer> root,long k){
        if(root==null) return 0L;
        long l=check(root.left,k);
        long r=check(root.right,k);
        if( l==k ||  r==k){
            isEqual=true;
            return -1;
        }
        return l+r+root.data;
    }
    public static boolean distributeChocolates(TreeNodesss<Integer> root) {
        // Write your code here.
        if(root==null) return false;
        isEqual=false;
        long s=calSum(root);
        if((s&1)==1) return false;
        check(root,s/2);
        return isEqual;

    }
}
