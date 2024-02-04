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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode curr=head;
        ListNode currp1=head.next;
        while(currp1!=null){
            if(curr.val==currp1.val){
                curr.next=curr.next.next;
                currp1=currp1.next;
            }
            else{
            curr=curr.next;
            currp1=currp1.next;
            }
        }
        return head;
    }
}