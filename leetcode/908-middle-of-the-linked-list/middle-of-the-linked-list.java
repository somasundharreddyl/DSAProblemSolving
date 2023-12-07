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
    public ListNode middleNode(ListNode head) {
        ListNode sPointer=head;
        ListNode fPointer=head;
        while(fPointer.next!=null&&fPointer.next.next!=null){
            sPointer=sPointer.next;
            fPointer=fPointer.next.next;
        }
        if(fPointer.next!=null){
        return sPointer.next;
        }
        return sPointer;
    }
}