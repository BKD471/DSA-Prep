package treess;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinTFromPreAndIn {
    private Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
    private TreeNode constructBst(int[] in,int[] pre,int is,int ie,int ps,int pe){
        if(is>ie && ps>pe) return null;

        int v=pre[ps];
        int indexOfElement=hash.get(v);
        int countOfElements=indexOfElement-is;
        TreeNode node=new TreeNode(v);
        node.left=constructBst(in,pre,is,is+countOfElements-1,ps+1,ps+countOfElements);
        node.right=constructBst(in,pre,is+countOfElements+1,ie,ps+countOfElements+1,pe);
        return node;
    }
    public TreeNode buildTree(int[] pre, int[] in) {
        int n=in.length;
        for(int i=0;i<n;i++) hash.put(in[i],i);
        return constructBst(in,pre,0,n-1,0,n-1);
    }
}

