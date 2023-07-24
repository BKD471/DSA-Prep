package linkedlist;

public class DeleteLL {
    public ListNode solve(ListNode head, int k) {
        if(head==null) return head;

        if(k==0){
            head=head.next;
            return head;
        }

        ListNode curr=head;
        for(int i=1;i<k;i++){
            if(curr.next==null) break;
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
}
