
package treess;


import java.util.*;



class Pair{
    int line;
    BinaryTreeNode node;
    Pair(int line,BinaryTreeNode node){
        this.line=line;
        this.node=node;
    }
}
public class TopView {

        public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
            ArrayList<Integer> res=new ArrayList<>();
            if(root==null) return res;

            Map<Integer,Integer> map=new TreeMap<>();
            Queue<Pair> q=new LinkedList<>();
            q.offer(new Pair(0,root));

            while(!q.isEmpty()){
                Pair temp=q.poll();
                int line=temp.line;
                BinaryTreeNode curr=temp.node;
                if(!map.containsKey(line)) map.put(line, curr.val);
                if(curr.left!=null) q.offer(new Pair(line-1,curr.left));
                if(curr.right!=null) q.offer(new Pair(line+1,curr.right));
            }

            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                res.add(entry.getValue());
            }
            return res;
        }
}
