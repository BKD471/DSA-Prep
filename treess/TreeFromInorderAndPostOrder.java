package treess;

import java.util.HashMap;
import java.util.Map;

public class TreeFromInorderAndPostOrder {
    Map<Integer,Integer> hash=new HashMap<>();
    private TreeNode letsBuildIt(int[] in,int[] pos,int ps,int pe,int is,int ie){
        if(ps>pe && is>ie) return null;

        int curr=pos[pe];
        int idx=hash.get(curr);
        TreeNode root=new TreeNode(curr);
        int x=idx-is;
        root.left=letsBuildIt(in,pos,ps,ps+x-1,is,idx-1);
        root.right=letsBuildIt(in,pos,ps+x,pe-1,idx+1,ie);
        return root;
    }

    public TreeNode buildTree(int[] in, int[] pos) {
        int n=in.length;

        for(int i=0;i<n;i++){
            int v=in[i];
            hash.put(v,i);
        }
        //reverse(pos);
        return letsBuildIt(in,pos,0,n-1,0,n-1);
    }
}
