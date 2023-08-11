package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWIthRandomPointers {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return head;
        RandomListNode t1=head;
        RandomListNode t2=new RandomListNode(t1.label);
        RandomListNode head2=t2;
        t1=t1.next;
        while(t1!=null){
            int v=t1.label;
            RandomListNode temp=new RandomListNode(v);
            t2.next=temp;
            t2=t2.next;
            t1=t1.next;
        }

        Map<RandomListNode,RandomListNode> hash=new HashMap<RandomListNode,RandomListNode>();
        t1=head;
        t2=head2;
        while(t1!=null){
            hash.put(t1,t2);
            t1=t1.next;
            t2=t2.next;
        }

        t1=head;t2=head2;
        while(t1!=null){
            t2.random=hash.get(t1.random);
            t1=t1.next;
            t2=t2.next;
        }
        return head2;
    }

    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

        public RandomListNode copyRandomListBetter(RandomListNode head) {
            if(head==null) return head;

            RandomListNode curr=head;
            while(curr!=null){
                RandomListNode after=curr.next;
                RandomListNode temp=new RandomListNode(curr.label);
                temp.next=after;
                curr.next=temp;
                curr=curr.next.next;
            }

            curr=head;
            while(curr!=null){
                if(curr.random!=null) curr.next.random=curr.random.next;
                curr=curr.next.next;
            }
            curr=head;
            RandomListNode headOfSecond=curr.next;
            while(curr!=null){
                RandomListNode next=curr.next;
                curr.next=next.next;
                curr=curr.next;
                if(curr!=null) next.next=curr.next;
            }
            return headOfSecond;
        }
}
