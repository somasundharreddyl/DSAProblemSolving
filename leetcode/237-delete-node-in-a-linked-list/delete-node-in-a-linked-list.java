/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node.next==null){
            node=null;
            return;
        }
        int val=node.next.val;
        ListNode nextNode=node.next.next;
        node.val=val;
        node.next=nextNode; 
    }
}