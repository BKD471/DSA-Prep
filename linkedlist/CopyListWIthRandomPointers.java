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
}
