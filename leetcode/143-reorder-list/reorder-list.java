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
        if(head==null && head.next==null){
            return;
        }
       ListNode fast=head;
       ListNode slow=head;
       while(fast.next!=null && fast.next.next!=null){
        fast=fast.next.next;
        slow=slow.next;
       }
       ListNode curr=slow.next;
       slow.next=null;
       ListNode prev=null;
       while(curr!=null){
           ListNode currp1=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currp1;
       }
       ListNode left=head;
       ListNode right=prev;
       while(right!=null){
       ListNode leftp1=left.next;
       ListNode rightp1=right.next;
        left.next=right;
        right.next=leftp1;
        left=leftp1;
        right=rightp1;
       }
    }
}