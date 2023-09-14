package treess;
import java.util.ArrayList;
public class AllAncestors {
    private static ArrayList<Integer> res=new ArrayList<>();

    private static boolean rootToNodePath(Node root,int k){

        if(root==null) return false;

        if(root.v==k){
            res.add(root.v);
            return true;
        }

        boolean l=rootToNodePath(root.left,k);
        boolean r=rootToNodePath(root.right,k);

        if(l || r)  res.add(root.v);
        return l || r;
    }
    public static ArrayList<Integer> Ancestors(Node root, int target)
    {
        // add your code here
        res.clear();
        if(root==null) return res;
        rootToNodePath(root,target);
        res.remove(0);
        return res;
    }
}
