import java.util.ArrayList;
import java.util.List;




public class BondaryTraversal {

    public boolean checkLeaf(Node a){
        if(a.left==null && a.right==null) return true;
        return false;
    }


    public void leftBoundary(Node root, List<Integer> res){
        if(root==null) return;

        Node a=root.left;
        while(a!=null){
            if(!checkLeaf(a)) res.add(a.val);
            if(a.left!=null) a=a.left;
            else a=a.right;
        }

    }

    public void rightBoundary(Node root,List<Integer> res){
        if(root==null) return;

        List<Integer> temp=new ArrayList<>();


        Node a=root.right;
        while(a!=null){
            if(!checkLeaf(a)) temp.add(a.val);
            if(a.right!=null) a=a.right;
            else a=a.left;
        }


        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }

    public void addLeaf(Node a,List<Integer> res){
        if(checkLeaf(a)){
            res.add(a.val);
            return;
        }

        if(a.left!=null) addLeaf(a.left,res);
        if(a.right!=null) addLeaf(a.right,res);

    }

    ArrayList <Integer> boundary(Node root)
    {
        ArrayList<Integer> res=new ArrayList<>();

        if(!checkLeaf(root)) res.add(root.val);

        leftBoundary(root,res);
        addLeaf(root,res);
        rightBoundary(root,res);

        return res;
    }
}
