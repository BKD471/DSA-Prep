package treess;

import java.util.LinkedList;
import  java.util.Queue;
class Node{
    int v;
    Node left;
    Node right;
    Node next;
    Node(int v){
        this.v=v;
        this.left=null;
        this.right=null;
        this.next=null;
    }
}

public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        if(root==null) return root;
        Node temp=root;
        Queue<Node> q=new LinkedList<>();
        q.offer(temp);
        q.offer(null);
        while(q.size()>1){
            Node curr=q.poll();
            if(curr==null){
                q.offer(null);
            }else{
                curr.next=q.peek();
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
        return root;
    }
}
