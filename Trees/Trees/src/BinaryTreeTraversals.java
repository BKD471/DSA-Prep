import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node right;
    Node left;

    Node(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class BinaryTreeTraversals {

    public static void inOrderTraversals(Node root){
        if(root==null) return;

        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversals(Node root){
        if(root==null) return;

        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversals(Node root){
        if(root==null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    public static void levelOrderTraversals(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp=q.poll();
            System.out.print(temp.val+" ");
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        inOrderTraversals(n1);
        System.out.println();
        preOrderTraversals(n1);
        System.out.println();
        postOrderTraversals(n1);
        System.out.println();
        levelOrderTraversals(n1);

    }
}
