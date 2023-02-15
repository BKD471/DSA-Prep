import java.util.*;

class Pairs{
    int line;
    Node temp;
    Pairs(Node temp,int line){
        this.temp=temp;
        this.line=line;
    }
    public Node getNode(){
        return this.temp;
    }
    public int getLine(){
        return this.line;
    }
}

public class TopView {
        static ArrayList<Integer> topView(Node root)
        {
            TreeMap<Integer,Integer> trmp=new TreeMap<>();
            Queue<Pairs> q= new LinkedList<>();
            ArrayList<Integer> res=new ArrayList<>();
            q.add(new Pairs(root,0));

            while(!q.isEmpty()){
                Pairs front=q.poll();
                Node tempNode=front.getNode();
                int line=front.getLine();

                if(!trmp.containsKey(line)){
                    trmp.put(line,tempNode.val);
                }

                if(tempNode.left!=null) q.add(new Pairs(tempNode.left,line-1));
                if(tempNode.right!=null) q.add(new Pairs(tempNode.right,line+1));
            }

            Collection v=trmp.values();
            Iterator it=v.iterator();
            while(it.hasNext()){
                res.add((Integer)it.next());
            }
            return res;
        }
}
