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
class PopulatingNextPointersBest{
    public Node connect(Node root) {
        if(root==null) return root;

        Node dummy=new Node(-1);
        Node temp=dummy;

        Node curr=root;
        curr.next=null;
        while(curr!=null){
            if(curr.left!=null) {
                temp.next=curr.left;
                temp=temp.next;
            }
            if(curr.right!=null){
                temp.next=curr.right;
                temp=temp.next;
            }
            curr=curr.next;
            if(curr==null){
                curr=dummy.next;
                dummy.next=null;
                temp=dummy;
            }
        }

        return root;
    }
    //tc O(n) sc O(1)
}
