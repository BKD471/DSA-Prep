package linkedlist;

public class MiddleLL {
    public int solve(ListNode head) {
        if(head==null) return 0;

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow.val;
    }
}
