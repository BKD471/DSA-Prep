package revision.linkedlist;

public class ReverseLL206 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode prev=null;
        ListNode curr=head;
        ListNode after=head;

        while(curr!=null){
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }

        return prev;
    }
}
