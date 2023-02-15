import java.util.*;

class Pairss{
    int line;
    Node node;
    Pairss(int line,Node node){
        this.line=line;
        this.node=node;
    }
    public int getLine(){
        return this.line;
    }
    public Node getNode(){
        return this.node;
    }
}

public class BottomView {
        //Function to return a list containing the bottom view of the given tree.
        public ArrayList<Integer> bottomView(Node root)
        {
            TreeMap<Integer,Integer> tmp=new TreeMap<>();
            Queue<Pairss> q=new LinkedList<>();
            ArrayList<Integer> res=new ArrayList<>();
            q.offer(new Pairss(0,root));
            while(!q.isEmpty()){
                Pairss front=q.poll();
                int line=front.getLine();
                Node tempNode=front.getNode();

                tmp.put(line,tempNode.val);

                if(tempNode.left!=null) q.offer(new Pairss(line-1,tempNode.left));
                if(tempNode.right!=null) q.offer(new Pairss(line+1,tempNode.right));
            }

            for(Map.Entry<Integer,Integer> entry:tmp.entrySet()){
                res.add(entry.getValue());
            }

            return res;
        }
}
