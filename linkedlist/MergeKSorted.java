package linkedlist;

public class MergeKSorted {
    private ListNode mergeTwoLists(ListNode list1,ListNode list2){

        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        if(list1.val<=list2.val) {
            temp.next=list1;
            temp=temp.next;
            list1=list1.next;
        }else{
            temp.next=list2;
            temp=temp.next;
            list2=list2.next;
        }

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }


        while(list1!=null){
            temp.next=list1;
            list1=list1.next;
            temp=temp.next;
        }


        while(list2!=null){
            temp.next=list2;
            list2=list2.next;
            temp=temp.next;
        }

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        ListNode curr=null;
        if(n==0) return curr;
        if(n==1) return lists[0];
        if(n==2) return mergeTwoLists(lists[0],lists[1]);

        curr=mergeTwoLists(lists[0],lists[1]);
        for(int i=2;i<n;i++) curr=mergeTwoLists(curr,lists[i]);
        return curr;
    }
}
