package linkedlist;

public class InsertInLinkedList {
    public int sizeLinkedList(ListNode head){
        int cnt=0;
        while(head!=null){
            head=head.next;
            cnt++;
        }
        return cnt;
    }
    public ListNode solve(ListNode head, int val, int k) {
        if(head==null) return head;
        int size=sizeLinkedList(head);
        if(k>size) k=size;
        if(k==0){
            ListNode node=new ListNode(val);
            node.next=head.next;
            head=node;
            return head;
        }

        ListNode curr=head;
        for(int i=1;i<k;i++){
            curr=curr.next;
        }
        ListNode node=new ListNode(val);
        node.next=curr.next;
        curr.next=node;
        return head;
    }
}
