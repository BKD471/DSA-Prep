import java.util.LinkedList;
import java.util.Queue;

class PairNode{
    int val;
    TreeNode node;
    PairNode(TreeNode node,int val){
        this.node=node;
        this.val=val;
    }
    public TreeNode getNode(){
        return this.node;
    }
    public int getValue(){
        return this.val;
    }
}
public class MaxWitdh {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<PairNode> q=new LinkedList<>();
        q.offer(new PairNode(root,0));
        int maxWidth=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size=q.size(),begin=-1,end=-1;
            for(int i=0;i<size;i++){
                PairNode front=q.peek();
                q.poll();

                TreeNode topNode=front.getNode();
                int topValue=front.getValue();

                if(i==0) begin=topValue;
                if(i==size-1) end=topValue;

                if(topNode.left!=null){
                    if(topValue==0) q.offer(new PairNode(topNode.left,2*topValue+1));
                    else q.offer(new PairNode(topNode.left,2*(topValue-1)+1));
                }

                if(topNode.right!=null){
                    if(topValue==0) q.offer(new PairNode(topNode.right,2*topValue+2));
                    else q.offer(new PairNode(topNode.right,2*(topValue-1)+2));
                }
                maxWidth=Math.max(maxWidth, end-begin+1);
            }
        }
        return maxWidth;
    }
}
