/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode fNode=head;
        ListNode sNode=head;

        //1.Divide into Two Halfs.
        while(fNode.next!=null && fNode.next.next!=null){
           sNode=sNode.next;
           fNode=fNode.next.next;
        }
        ListNode shFNode=sNode.next;
        if(fNode.next!=null){
            fNode=fNode.next;
        }

      //2.Revers the Second Half.
       ListNode prev=null;
       ListNode curr=shFNode;

       while(curr!=null){
       ListNode temp=curr.next;
       curr.next=prev;
       prev=curr;
       curr=temp;
       }
      shFNode=prev;

     ListNode fhFNode=head;
     while(fhFNode!=sNode){
     ListNode temp=fhFNode.next;
     fhFNode.next=shFNode;
     ListNode temp1=shFNode.next;
     shFNode.next=temp;
     shFNode=temp1;
     fhFNode=fhFNode.next.next;
     }
     fhFNode.next=shFNode;
    
    }
}