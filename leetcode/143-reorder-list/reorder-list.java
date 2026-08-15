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
        ListNode fastNode=head;
        ListNode slowNode=head;
        while(fastNode!=null && fastNode.next!=null && fastNode.next.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
        }
        ListNode currNode=slowNode.next;
        ListNode prevNode=null;
        slowNode.next=null;
        while(currNode!=null){
            ListNode nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
        }
        ListNode firstNode=head;
        ListNode secNode=prevNode;
        while(firstNode!=null && secNode!=null){
          ListNode firstnextNode=firstNode.next;
          ListNode secnextNode=secNode.next;
          firstNode.next=secNode;
          firstNode.next.next=firstnextNode;
          secNode=secnextNode;
          firstNode=firstnextNode;
        }
        
    }
}