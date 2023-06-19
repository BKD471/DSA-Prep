package revision.linkedlist;

public class DeleteNodeLL237 {
    public void deleteNode(ListNode node) {
        ListNode after=node.next;
        node.val=after.val;
        node.next=after.next;
    }
}
