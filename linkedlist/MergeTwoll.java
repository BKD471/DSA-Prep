package linkedlist;

public class MergeTwoll {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if(h2==null) return h1;
        if(h1==null) return h2;

        ListNode h3=null,t=null;
        if(h1.val<h2.val) {
            h3=h1;
            t=h1;
            h1=h1.next;
        }else{
            h3=h2;
            t=h2;
            h2=h2.next;
        }


        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                t.next=h1;
                t=t.next;
                h1=h1.next;
            }else{
                t.next=h2;
                t=t.next;
                h2=h2.next;
            }
        }

        if(h1!=null) t.next=h1;
        if(h2!=null) t.next=h2;

        return h3;
    }
}
