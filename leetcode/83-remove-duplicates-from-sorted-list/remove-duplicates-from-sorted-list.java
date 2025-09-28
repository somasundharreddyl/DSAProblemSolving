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
        ListNode curr=head;
        if(head ==null || head.next==null){
            return head;
        }
        ListNode currNext=head.next;
        while(currNext!=null){
             if(curr.val==currNext.val){
                curr.next=currNext.next;
                currNext=curr.next;
             }else{
                curr=currNext;
                currNext=currNext.next;
             }
        }
        return head;
    }
}