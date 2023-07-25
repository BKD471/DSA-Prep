package linkedlist;

public class RemoveLoopLl {
    public ListNode solve(ListNode head) {
        if(head==null) return head;

        ListNode fast=head;
        ListNode slow=head;
        boolean isLoop=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) {
                isLoop=true;
                break;
            }
        }

        if(!isLoop) return null;

        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        ListNode end=slow;
        while(end.next!=slow){
            end=end.next;
        }

        end.next=null;
        return head;
    }
}
