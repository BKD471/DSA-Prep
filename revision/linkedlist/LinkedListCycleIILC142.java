package revision.linkedlist;

public class LinkedListCycleIILC142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode fast=head;
        ListNode slow=head;

        ListNode temp=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                temp=slow;
                break;
            }
        }

        if(temp==null) return null;

        slow=head;
        fast=temp;
        while(slow!=null){
            if(slow==fast) return fast;
            slow=slow.next;
            fast=fast.next;
        }
        return null;
    }
}
