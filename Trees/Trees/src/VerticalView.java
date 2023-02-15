import java.util.*;

class Pair{
    int vertical;
    int horizontal;
    TreeNode node;
    Pair(TreeNode node,int vertical,int horizontal){
        this.vertical=vertical;
        this.horizontal=horizontal;
        this.node=node;
    }
    public TreeNode getNode(){
        return this.node;
    }
    public int getVertical(){
        return this.vertical;
    }
    public int getHorizontal(){
        return this.horizontal;
    }
}


public class VerticalView {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> res=new ArrayList<>();
            TreeMap<Integer, TreeMap<Integer,List<Integer>>> tmp=new TreeMap<>();
            Queue<Pair> q=new LinkedList<Pair>();
            q.offer(new Pair(root,0,0));

            while(!q.isEmpty()){
                Pair front=q.poll();
                TreeNode tempNode=front.getNode();
                int tempVertical=front.getVertical();
                int tempHorizontal=front.getHorizontal();

                if(tmp.containsKey(tempVertical)){
                    TreeMap<Integer,List<Integer>> tempMap=tmp.get(tempVertical);
                    if(tempMap.containsKey(tempHorizontal)){
                        List<Integer> tempList=tempMap.get(tempHorizontal);
                        tempList.add(tempNode.val);
                        tempMap.put(tempHorizontal,tempList);
                    }else{
                        List<Integer> newTempList=new ArrayList<>();
                        newTempList.add(tempNode.val);
                        tempMap.put(tempHorizontal,newTempList);
                    }
                }else{
                    TreeMap<Integer,List<Integer>> tempMap1=new TreeMap<>();
                    List<Integer> newTempList=new ArrayList<>();
                    newTempList.add(tempNode.val);
                    tempMap1.put(tempHorizontal,newTempList);
                    tmp.put(tempVertical,tempMap1);
                }

                if(tempNode.left!=null) q.offer(new Pair(tempNode.left,tempVertical-1,tempHorizontal+1));
                if(tempNode.right!=null) q.offer(new Pair(tempNode.right,tempVertical+1,tempHorizontal+1));

            }

            for(TreeMap<Integer,List<Integer>> entry:tmp.values()){
                List<Integer> tempList=new ArrayList<>();
                for(Map.Entry<Integer,List<Integer>> entry1:entry.entrySet()){
                    List<Integer> temp=entry1.getValue();
                    Collections.sort(temp);
                    tempList.addAll(temp);
                }
                res.add(tempList);
            }

            return res;

        }

}
