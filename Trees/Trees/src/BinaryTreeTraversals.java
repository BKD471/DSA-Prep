import java.util.*;

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

        inOrderTraversals(root.left);
        System.out.print(root.val+" ");
        inOrderTraversals(root.right);
    }

    public static void inOrderTraversalsIterative(Node root){
        if(root==null) return;
        List<Integer> res=new ArrayList<>();
        Stack<Node> st=new Stack<>();

        while(true){
            if(root!=null){
                st.push(root);
                root=root.left;
            }else{
                if(st.empty()==true) break;
                Node top=st.peek();
                st.pop();
                res.add(top.val);
                root=top.right;

            }
        }

        System.out.println(res);
    }


    public static void preOrderTraversalsIterative(Node root){
        if(root==null) return;
        List<Integer> res=new ArrayList<>();
        Stack<Node> st=new Stack<>();
        st.push(root);


        while(!st.empty()){
            Node top=st.peek();
            st.pop();
            res.add(top.val);
            if(top.right!=null) st.push(top.right);
            if(top.left!=null) st.push(top.left);

        }
        System.out.println(res);
    }

    public static void  postOrderTraversalIterative(Node root){
        if(root==null) return;

        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        List<Integer> res=new ArrayList<>();

        st1.push(root);
        while(!st1.empty()){

            Node temp=st1.peek();
            st1.pop();
            st2.push(temp);
            if(temp.left!=null) st1.push(temp.left);
            if(temp.right!=null) st1.push(temp.right);
        }

        while(!st2.empty()){
            Node temp=st2.peek();
            st2.pop();
            res.add(temp.val);
        }
        System.out.println(res);
    }

    public static void preOrderTraversals(Node root){
        if(root==null) return;

        System.out.print(root.val+" ");
        preOrderTraversals(root.left);
        preOrderTraversals(root.right);
    }

    public static void postOrderTraversals(Node root){
        if(root==null) return;

        postOrderTraversals(root.left);
        postOrderTraversals(root.right);
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
        System.out.println();
        inOrderTraversalsIterative(n1);
        System.out.println();
        preOrderTraversalsIterative(n1);
        System.out.println();
        postOrderTraversalIterative(n1);

    }
}
