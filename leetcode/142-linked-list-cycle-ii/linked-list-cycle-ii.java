/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode slowNode=head.next;
        ListNode fastNode=head.next.next;
        while(fastNode!=null && fastNode.next!=null && slowNode!=fastNode){
            slowNode=slowNode.next;
            fastNode=fastNode.next.next;
        }
        if(fastNode==null || fastNode.next==null){
            return null;
        }
        slowNode=head;
        while(slowNode!=fastNode){
            slowNode=slowNode.next;
            fastNode=fastNode.next;
        }
        return slowNode;
    }
}