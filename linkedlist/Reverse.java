package linkedlist;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode curr=head,prev=null;
        while(curr!=null){
            ListNode after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        return prev;
    }
}
