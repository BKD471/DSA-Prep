package revision.linkedlist;

public class PallinDromeLL234 {
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode after=head;
        ListNode prev=null;
        while(curr!=null){
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        return prev;
    }


    public boolean isPalindrome(ListNode head) {
        if(head==null) return false;

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=head;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=null;
        ListNode second=reverse(slow);
        ListNode curr=head;
        while(second!=null && curr!=null){
            if(curr.val!=second.val) return false;
            curr=curr.next;
            second=second.next;
        }

        return true;
    }
}
